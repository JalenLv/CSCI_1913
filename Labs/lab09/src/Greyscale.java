// Name: Qiming Lyu

public class Greyscale extends Transformation {
    /**
     * Constructor for Greyscale transformation
     */
    public Greyscale() {
        // Do nothing
    }

    /**
     * This method applies the greyscale transformation to a pixel in the image.
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
        int rgb_average = (originalColor.getRed() + originalColor.getGreen() + originalColor.getBlue()) / 3;
        return new RGBColor(rgb_average, rgb_average, rgb_average);
    }
}
