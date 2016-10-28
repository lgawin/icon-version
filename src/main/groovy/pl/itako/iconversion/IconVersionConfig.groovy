package pl.itako.iconversion

import java.awt.Color

/**
 * Allow users of this extension to customize properties of their builds
 */
class IconVersionConfig {

    static DEFAULT = new IconVersionConfig()

    static TRANSPARENT = new Color(0, 0, 0, 0)

    /**
     * The size of the text to draw on top of the icon
     */
    int fontSize = 12

    /**
     * The amount of vertical space between each line of text
     */
    int verticalLinePadding = 4

    /**
     * Text color to draw behind the text
     */
    int[] backgroundOverlayColor = [0, 0, 0, 136]

    /**
     * The text color to draw the overlaid text.
     */
    int[] textColor = [255, 255, 255, 255]

    /**
     * If set to true always indicate build type. Otherwise type is omitted for non-debuggable variants
     * or when only debuggable variants are decorated (productionFlavors is empty).
     */
    boolean forceBuildType = false

    /**
     * Allows to list flavors which are published and should not have any icon decorations added.
     * If the list is empty, only debuggable variants are decorated, and build type info is not attached
     * unless forceBuildType is set.
     */
    String[] productionFlavors = []

    public Color getBackgroundOverlayColor() {
        return intArrayToColor(backgroundOverlayColor) ?: TRANSPARENT
    }

    public Color getTextColor() {
        return intArrayToColor(textColor) ?: TRANSPARENT
    }

    private static Color intArrayToColor(int[] colorParts) {
        if (colorParts == null || colorParts.length != 4) {
            return null;
        } else {
            return new Color(colorParts[0], colorParts[1], colorParts[2], colorParts[3])
        }
    }
}