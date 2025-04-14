/**
 * A class to represent an image as a 2d grid of RGB values.
 * While this class internally stores the image as a 2d array -- you often won't have to deal with this array
 * and should instead interact through public getcolor and setColor methods.
 *
 * @author Daniel Kluver
 */
public class RGBImage {
    private RGBColor[][] data;

    /**
     * constructor -- used when you already have image data.
     * */
    public RGBImage(RGBColor[][] data) {
        this.data = data;
    }


    /**
     * constructor -- used to request a copy of an image
     * This guarantees a deep copy -- this image will be fully seperate
     * from the original image
     */
    public RGBImage(RGBImage other) {
        this.data = new RGBColor[other.getWidth()][other.getHeight()];
        for (int x = 0; x < getWidth(); x++) {
            for(int y = 0; y < getHeight(); y++) {
                // note, we can transfer color objects directly without
                // fear because they are immutable!
                setColor(x, y, other.getColor(x, y));
            }
        }
    }

    /**
     * create an empty (black) image
     * @param width width of the image
     * @param height height of the image.
     */
    public RGBImage(int width, int height) {
        RGBColor black = new RGBColor(0, 0, 0);
        this.data = new RGBColor[width][height];
        for (int x = 0; x < getWidth(); x++) {
            for(int y = 0; y < getHeight(); y++) {
                setColor(x, y, black);
            }
        }
    }

    /**
     * get the width of this image
     */
    public int getWidth() {
        return data.length;
    }

    /**
     * get the height of this image
     */
    public int getHeight() {
        return data[0].length;
    }

    /**
     * get the color at a given index. x and y values match the normal computer representation (I.E. (0,0) is the
     * upper-left corner, with larger x values going right, and larger y values going down.
     * @param x an integer between 0 (inclusive) and width (exclusive)
     * @param y an integer between 0 (inclusive) and height (exclusive)
     * @return an RGBColor indicating what color is at a given position in an image. if invalid x or y positions are
     *         given, a value of null is returned.
     */
    public RGBColor getColor(int x, int y) {
        if (0 <= x && x < getWidth() && 0 <= y && y < getHeight()) {
            return data[x][y];
        } else {
            return null;
        }
    }

    /**
     * change the color at a given positing. x and y values match the normal computer representation (I.E. (0,0) is the
     * upper-left corner, with larger x values going right, and larger y values going down.
     *
     * If invalid x, y values are given, this will not change the image, and will instead silently fail.
     *
     * @param x an integer between 0 (inclusive) and width (exclusive)
     * @param y an integer between 0 (inclusive) and height (exclusive)
     */
    public void setColor(int x, int y, RGBColor color) {
        if (0 <= x && x < getWidth() && 0 <= y && y < getHeight()) {
            data[x][y] = color;
        }
    }
}
