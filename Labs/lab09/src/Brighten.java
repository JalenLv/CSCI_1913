// Name: Qiming Lyu

public class Brighten extends Transformation {
    private final int amount;

    /**
     * Constructor to initialize the Brighten transformation with a specified
     * amount.
     *
     * @param amount -- the amount to brighten the image. Positive values will
     *               increase brightness, negative values will decrease brightness.
     */
    public Brighten(int amount) {
        if (amount >= 0)
            this.amount = RGBColor.clamp(amount);
        else
            this.amount = -RGBColor.clamp(-amount);
    }

    /**
     * This method applies the brighten transformation to a pixel in the image.
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
        return new RGBColor(RGBColor.clamp(originalColor.getRed() + amount),
                RGBColor.clamp(originalColor.getGreen() + amount),
                RGBColor.clamp(originalColor.getBlue() + amount));
    }
}
