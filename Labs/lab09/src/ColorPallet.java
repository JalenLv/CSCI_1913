// Name: Qiming Lyu

public class ColorPallet extends Transformation {
    private final RGBColor[] pallet;

    /**
     * Construct a ColorPallet transformation.
     * 
     * @param pallet -- an array of RGBColor objects representing the color pallet.
     */
    public ColorPallet(RGBColor[] pallet) {
        this.pallet = pallet;
    }

    /**
     * This method applies the ColorPallet transformation to a pixel in the image.
     * 
     * @param x             -- the x position of this color
     * @param y             -- the y position of the color
     * @param originalColor -- the original color.
     * @param image         -- the image being converted.
     *
     * @return the new color for this location in the image.
     */
    @Override
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        // find the closest match in the pallet
        RGBColor closestMatch = pallet[0];
        for (RGBColor color : pallet)
            if (RGBColor.distance(color, originalColor) < RGBColor.distance(closestMatch, originalColor))
                closestMatch = color;
        return closestMatch;
    }
}
