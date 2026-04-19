package dev.deimoslabs.easysignmarkers.helpers;

/**
 * Enumeration of available marker icon identifiers. Each constant maps to an image
 * file named {icon}.png inside the BlueMap webroot (under the plugin IMAGE_PATH).
 */
public enum MarkerIcon {
    anchor,
    bank,
    basket,
    bed,
    beer,
    bighouse,
    blueflag,
    bomb,
    bookshelf,
    bricks,
    bronzemedal,
    bronzestar,
    building,
    cake,
    camera,
    cart,
    caution,
    chest,
    church,
    coins,
    comment,
    compass,
    construction,
    cross,
    cup,
    cutlery,
    diamond,
    dog,
    door,
    down,
    drink,
    end,
    exclamation,
    factory,
    fire,
    flower,
    gear,
    goldmedal,
    goldstar,
    greenflag,
    hammer,
    heart,
    house,
    key,
    king,
    left,
    lightbulb,
    lighthouse,
    lock,
    map,
    minecart,
    offlineuser,
    orangeflag,
    pinkflag,
    pirateflag,
    pointdown,
    pointleft,
    pointright,
    pointup,
    portal,
    purpleflag,
    queen,
    redflag,
    right,
    ruby,
    scales,
    shield,
    sign,
    silvermedal,
    silverstar,
    skull,
    star,
    sun,
    temple,
    theater,
    tornado,
    tower,
    tree,
    truck,
    up,
    walk,
    warning,
    world,
    wrench,
    yellowflag,
    pin,
    papaj;

    /**
     * Matches a bracketed token (like "[map]") to the corresponding enum constant.
     * The input is normalized by removing surrounding brackets and lower-casing the content.
     *
     * @param name bracketed token to match (e.g. "[map]")
     * @return the matching {@link MarkerIcon} constant, or if cannot match - defaults to {@link MarkerIcon#map}
     */
    public static MarkerIcon match(String name) {
        MarkerIcon icon = MarkerIcon.map;
        String result = name.replaceAll("^\\[(.*)]$", "$1").toLowerCase();
        try {
            icon = MarkerIcon.valueOf(result);
        } catch (IllegalArgumentException ignored) {
        }
        return icon;

    }

}
