/**
 * A parent class for other transformations.
 * Your job will be building subclasses of this and then USING the class
 */
public class Transformation {

    /**
     * Create a new image based on a provided RGBImage
     * The new image will be a transformation of the original.
     * For this specific class the transformation will have it's reg/green/blue
     * values scrambled.
     * But subclasses are encouraged to redefine the transformation.
     * But in general.
     * 
     * @param image
     * @return
     */
    public RGBImage transform(RGBImage image) {
        RGBImage retVal = new RGBImage(image.getWidth(), image.getHeight());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                retVal.setColor(x, y, do_transform(x, y, image.getColor(x, y), image));
            }
        }
        return retVal;
    }

    /**
     * This function is actually in charge of defining a transformation.
     * It is protected so that:
     * * It is private to unrelated classes (this is an internal detail -- not a
     * part of the public API)
     * * It is available to be changed by subclasses.
     * 
     * @param x             -- the x position of this color
     * @param y             -- the y position of the color
     * @param originalColor -- the original color.
     * @param image         -- the image being converted. Most transformation should
     *                      not need to access this at all,
     *                      but some transformations will (maybe they need the
     *                      width/height of the image...)
     *                      so we make it available here, and encourage most
     *                      implementations to ignore it.
     * @return the new color for this location in the image.
     */
    protected RGBColor do_transform(int x, int y, RGBColor originalColor, RGBImage image) {
        // Scramble the color values up -- it's always a fun transformation!
        return new RGBColor(originalColor.getGreen(), originalColor.getBlue(), originalColor.getRed());
    }
}
