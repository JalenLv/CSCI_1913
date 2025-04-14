/**
 * A simple class representing color as 3 integers -- red, green, and blue, each
 * between 0 and 255.
 * This is a VERY common way for computers to represent colors in software.
 * For more information see: https://en.wikipedia.org/wiki/RGB_color_model or,
 * to just "play around with it" you can
 * use tools like this: https://www.w3schools.com/colors/colors_rgb.asp to
 * develop an intuition about how these numbers
 * map to colors.
 *
 * This class is immutable -- you can't change the red/green/blue values after
 * the constructor.
 *
 * @Author Daniel Kluver
 */

public class RGBColor {
    private final int red, green, blue;

    public RGBColor(int red, int green, int blue) {
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    /**
     * provides a nice string representation of the color
     */
    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ")";
    }

    @Override
    /**
     * Checks if two colors are equal
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RGBColor rgbColor = (RGBColor) o;
        return red == rgbColor.red &&
                green == rgbColor.green &&
                blue == rgbColor.blue;
    }

    /**
     * Computer color values are strictly between 0 and 255
     * this function makes sure that an integer is in this range as well
     * 
     * @param colorVal a red, green, or blue color value.
     * @return the closest number the 0-255 valid color range.
     */
    public static int clamp(int colorVal) {
        if (colorVal < 0) {
            return 0;
        } else if (colorVal > 255) {
            return 255;
        } else {
            return colorVal;
        }
    }

    /**
     * Compute a "distance" between two colors.
     * This is only an approximation -- don't expect it to perfectly match your
     * human understanding
     * of colors and their relationships. But it is more than good enough for most
     * computer purposes.
     * Especially for relatively *non-artistic* purposes.
     * 
     * @param c1 a non-null RGBColor object
     * @param c2 a non-null RGBColor object
     * @return a distance value -- this will be a positive number greater than 0. If
     *         given two equal colors a value of 0
     *         will be returned. smaller values indicate colors that are more
     *         similar. Larger numbers indicate colors
     *         that are not similar.
     */
    public static double distance(RGBColor c1, RGBColor c2) {
        return Math
                .sqrt(Math.pow(c1.red - c2.red, 2) + Math.pow(c1.green - c2.green, 2) + Math.pow(c1.blue - c2.blue, 2));
    }

}
