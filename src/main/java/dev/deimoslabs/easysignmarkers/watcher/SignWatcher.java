package dev.deimoslabs.easysignmarkers.watcher;


import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import de.bluecolored.bluemap.api.markers.Marker;
import de.bluecolored.bluemap.api.markers.MarkerSet;
import de.bluecolored.bluemap.api.markers.POIMarker;
import dev.deimoslabs.easysignmarkers.FeatureProvider;
import dev.deimoslabs.easysignmarkers.helpers.MarkerIcon;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static dev.deimoslabs.easysignmarkers.Constants.*;

/**
 * Listener that watches for sign creation and destruction events and manages
 * corresponding BlueMap markers based on sign contents.
 * Behavior summary:
 * - When a player writes a sign with a recognized icon tag on the first line (e.g. "[map]")
 * the listener will attempt to create a POI marker on BlueMap using the chosen icon and
 * the text from lines 1-3 as the marker label/details.
 * - When a sign is broken, the listener will remove the marker with the corresponding
 * coordinate-based id from the marker set for that world.
 */
public class SignWatcher implements Listener {

    /**
     * FeatureProvider used to access plugin-level facilities:
     * - BlueMap webroot path (for icons)
     * - plugin {@link java.util.logging.Logger}
     * - the central map of {@link org.bukkit.World} -> {@link de.bluecolored.bluemap.api.markers.MarkerSet}
     */
    private final FeatureProvider featureProvider;

    // Adventure Component → plain String serializer (without color codes).
    // Used to read the text content of sign lines.
    private static final PlainTextComponentSerializer PLAIN = PlainTextComponentSerializer.plainText();

    /**
     * Constructs a SignWatcher using the provided FeatureProvider to access plugin features.
     *
     * @param featureProvider provider exposing BlueMap webroot, logger and marker map
     */
    public SignWatcher(FeatureProvider featureProvider) {
        this.featureProvider = featureProvider;
    }

    /**
     * Handles sign change events (player writes a sign).
     * <p>
     * Expected workflow:
     * - Reads the first line and attempts to match an icon token (e.g. "[map]").
     * - If an icon is found and its image exists in BlueMap's webroot, constructs a POI marker
     * using the sign's position and lines 1-3 as label/detail.
     * - Stores the marker in the marker map under an id built from the block coordinates.
     * - Replaces the first line of the sign with a marker indicator and notifies the player.
     * If image reading or file access fails, the error is logged and the marker is not created.
     *
     * @param event the SignChangeEvent triggered when a player finalizes sign text
     */
    @EventHandler
    public void onSignWrite(SignChangeEvent event) {

        String iconLabel;
        MarkerIcon markerIcon;

        // ### Mapping sign's line 0 to specific marker type (translates to icon)
        // line(int) returns a Component; we serialize it to plain text for tag parsing.
        final Component line0Component = event.line(0);
        final String line0 = line0Component != null ? PLAIN.serialize(line0Component) : "";

        if (!line0.isBlank() && line0.startsWith("[") && line0.endsWith("]")) {
            markerIcon = MarkerIcon.match(line0);
            iconLabel = markerIcon.name();
        } else {
            return;
        }


        // ### Getting the actual image file for a marker
        String icon = IMAGE_PATH + iconLabel + ".png";
        File iconFile = new File(featureProvider.getWebRoot() + "/" + icon);
        if (!iconFile.exists()) return;

        Vector2i anchor;
        try {
            BufferedImage image = ImageIO.read(iconFile);
            int width = image.getWidth();
            int height = image.getHeight();
            anchor = new Vector2i(height / 2, width / 2);
        } catch (IOException e) {
            featureProvider.getLogger().warning(String.format("Something wrong with image %s, details: %s", iconFile.getPath(), e.getMessage()));
            return;
        }


        // ### Building label for the sign, from lines 1-3
        // Each line is a Component; null-safely converted to a plain String.
        final String label1 = serializeLine(event.line(1));
        final String label2 = serializeLine(event.line(2));
        final String label3 = serializeLine(event.line(3));

        String fullLabel = (label1 + " " + label2 + " " + label3).trim();

        // ### No description - no marker
        if (fullLabel.isBlank()) return;

        // ### Getting sign's block XYZ position. This will be marker's id
        Block block = event.getBlock();
        Vector3d pos = new Vector3d(block.getX(), block.getY(), block.getZ());

        String id = MARKER_ID_PREFIX + pos.getX() + "-" + pos.getY() + "-" + pos.getZ();
        MarkerContent markerContent = MarkerContent.builder()
                .label1(label1)
                .label2(label2)
                .label3(label3)
                .position(pos)
                .author(event.getPlayer().getName())
                .build();
        String markerDetails = buildMarkerContent(markerContent);
        POIMarker marker = POIMarker.builder().position(pos).label(fullLabel).icon(icon, anchor).maxDistance(100000).detail(markerDetails).build();
        featureProvider.getMarkerSet().get(block.getWorld()).put(id, marker);

        // ### Replace first line with marker indicator via new line(int, Component) setter
        event.line(0, Component.text(MARKER_PLACEHOLDER));
        event.getPlayer().sendMessage(formatMessage(String.format(ADDED_TEMPLATE, markerIcon.name(), pos.getFloorX(), pos.getFloorY(), pos.getFloorZ())));
    }

    /**
     * Handles block break events to remove markers when signs are destroyed.
     * If the broken block is a sign and a marker with the corresponding coordinate-based id
     * exists in the marker set, the marker will be removed and the player will be notified.
     *
     * @param event the BlockBreakEvent representing the block destruction
     */
    @EventHandler
    public void onSignDestroy(BlockBreakEvent event) {

        Block block = event.getBlock();
        if (!(block.getState() instanceof Sign)) return;

        MarkerSet set = featureProvider.getMarkerSet().get(block.getWorld());
        if (set == null) return;

        Vector3d pos = new Vector3d(block.getX(), block.getY(), block.getZ());
        String id = MARKER_ID_PREFIX + pos.getX() + "-" + pos.getY() + "-" + pos.getZ();

        Marker marker = set.get(id);
        if (marker == null) return;
        set.remove(id);

        event.getPlayer().sendMessage(formatMessage(String.format(REMOVED_TEMPLATE, (int) pos.getX(), (int) pos.getY(), (int) pos.getZ())));
    }

    /**
     * Null-safe serialization of an Adventure {@link Component} to a plain String.
     * If the component is null (empty sign line), an empty string is returned.
     *
     * @param component the sign line as a Component, may be null
     * @return plain-text representation of the line
     */
    private String serializeLine(Component component) {
        return component != null ? PLAIN.serialize(component) : "";
    }

    /**
     * Builds the HTML content for a marker's detail popup using the provided information.
     *
     * @param content {@link MarkerContent} object containing label lines, position, timestamp and author
     * @return HTML string suitable for use as the marker detail content (ready to be passed to BlueMap)
     */
    private String buildMarkerContent(MarkerContent content) {
        return String.format(HTML_TEMPLATE,
                content.getLabel1(),
                content.getLabel2(),
                content.getLabel3(),
                content.getX(),
                content.getY(),
                content.getZ(),
                content.getTimestamp(),
                content.getAuthor());
    }

    /**
     * Formats a message using MiniMessage/Legacy templates for player feedback.
     *
     * @param message the message text to format
     * @return an Adventure {@link String} ready to send to a player
     */
    private String formatMessage(String message) {
        return LegacyComponentSerializer.legacySection()
                .serialize(MiniMessage.miniMessage().deserialize(String.format(MSG_PREFIX, message)));
    }
}