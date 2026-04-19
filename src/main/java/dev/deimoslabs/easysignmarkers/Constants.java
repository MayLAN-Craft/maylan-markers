package dev.deimoslabs.easysignmarkers;

/**
 * Common constants used across the plugin.
 */
public class Constants {
    /** Modrinth plugin slug used for update checks. */
    public static final String MODRINTH_SLUG = "easy-bluemap-sign-markers";
    /**
     * Relative path inside BlueMap webroot where marker images are stored.
     */
    public static final String IMAGE_PATH = "markers/";
    /**
     * Resource folder inside the plugin JAR where marker images are located.
     */
    public static final String RES_FOLDER = IMAGE_PATH + "dynmap";
    /**
     * Prefix used when creating per-world marker set filenames.
     */
    public final static String MARKER_SET_PREFIX = "marker-set-";

    /**
     * Prefix used when creating per-world marker id.
     */
    public final static String MARKER_ID_PREFIX = "marker-";

    /**
     * Label prefix displayed in BlueMap for sign markers.
     */
    public final static String SIGN_MARKERS_PREFIX = "Табличный маркер ";
    /**
     * Suffix for the JSON files that store marker sets.
     */
    public final static String JSON_FILENAME = ".json";
    /**
     * Template message shown when a marker is removed. Format args: x, y, z (integers).
     */
    public final static String REMOVED_TEMPLATE = "Маркер удалён на координатах %d %d %d";

    /**
     * Template message shown when a marker is added. Format args: s (string), x, y, z (integers).
     */
    public final static String ADDED_TEMPLATE = "Маркер <%s> добавлен на координатах %d %d %d";

    /**
    * Placeholder text used in marker labels to indicate where the marker text goes.
     */
    public final static String MARKER_PLACEHOLDER = "> marker <";

    /**
     * MiniMessage template used for player messages. Argument: marker text.
     */
    public final static String MSG_PREFIX = "<green>[MaylanMarkers] %s</green>";
    /**
     * HTML template used as the marker detail content. The first three string placeholders
     * are used for the three label lines. Subsequent placeholders are used for X, Y, Z,
     * timestamp and author (in that order).
     */
    public final static String HTML_TEMPLATE = """
            <div style='
                padding: 10px;
                text-align: center;
                line-height: 1.4;
                font-family: Minecraft,sans-serif;
                min-width: 170px;
            '>
            <div style='border-style: dashed; border-width: 2px; border-color: var(--theme-fg-light); padding: 5px; margin-bottom: 10px'>
                            <div style='color: var(--theme-fg); font-size: 1em;'>%s</div>
                            <div style='color: var(--theme-fg); font-size: 1em;'>%s</div>
                            <div style='color: var(--theme-fg); font-size: 1em;'>%s</div>
                            </div>
                <div style='color: var(--theme-fg-light); font-size: 0.6em;'>координаты (x y z)</div>
                <div style='color: var(--theme-fg); font-size: 0.7em;'>%d %d %d</div>
                <div style='color: var(--theme-fg-light); font-size: 0.6em;'>создано %s</div>
                <div style='color: var(--theme-fg); font-size: 0.7em;'>игроком %s</div>
            </div>
            
            """;
}
