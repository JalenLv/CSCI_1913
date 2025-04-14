// Name: Qiming Lyu

public class AddBorder extends Transformation {
    private final int width;
    private final RGBColor borderColor;

    /**
     * Constructor with width and color parameters.
     *
     * @param width       -- the width of the border
     * @param borderColor -- the color of the border
     */
    public AddBorder(int width, RGBColor borderColor) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be non-negative.");
        }
        this.width = width;
        this.borderColor = borderColor;
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
        return isBorderPixel(x, y, image) ? borderColor : originalColor;
    }

    /**
     * Helper method to determine if a pixel is part of the border.
     *
     * @param x     -- the x coordinate of the pixel
     * @param y     -- the y coordinate of the pixel
     * @param image -- the image being processed
     */
    private boolean isBorderPixel(int x, int y, RGBImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        return (x < this.width || x >= width - this.width ||
                y < this.width || y >= height - this.width);
    }
}
