// Name: Qiming Lyu

public class Stamp extends Transformation {
    private final RGBImage toStamp;

    /**
     * Construct a Stamp transformation.
     *
     * @param toStamp -- the RGBImage to stamp on the original image.
     */
    public Stamp(RGBImage toStamp) {
        this.toStamp = toStamp;
    }

    /**
     * This method applies the AddBorder transformation to a pixel in the image.
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
        if (isTopLeftCorner(x, y)) {
            RGBColor newColor = new RGBColor(
                    (originalColor.getRed() + toStamp.getColor(x, y).getRed()) / 2,
                    (originalColor.getGreen() + toStamp.getColor(x, y).getGreen()) / 2,
                    (originalColor.getBlue() + toStamp.getColor(x, y).getBlue()) / 2);
            return newColor;
        } else
            return originalColor;
    }

    /**
     * Helper method to determine if a pixel is in the top left corner
     *
     * @param x -- the x coordinate of the pixel
     * @param y -- the y coordinate of the pixel
     */
    private boolean isTopLeftCorner(int x, int y) {
        return x >= 0 && x < toStamp.getWidth() && y >= 0 && y < toStamp.getHeight();
    }
}
