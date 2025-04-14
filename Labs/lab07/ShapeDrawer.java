/**
 * Shape Drawer class file.
 * CSCI 1913.
 * Written by Min Namgung, Daniel Kluver, and Peter Wang
 * Provided.
 *
 * While the internal workings of this class are complicated, the use of this
 * class is not. It is a deliberate challenge for you to read through the documentation
 * and function names of this class to figure out how to use it.
 */


import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * The Shape Drawer class most accurate represents a _drawning canvas_
 * You create it with a given size, then you call draw functions to "paint it"
 * Then at the end you use the writeToFile function to save it to a standard output format.
 * So an "average" use if this class might look kind of like this:
 * <pre>
 *     ShapeDrawer myDraw = new ShapeDrawer(100, 120); // 100 wide, 120 tall
 *     // create shape objects
 *     Circle c = new Circle(new Point(50,60), 40);
 *     // and draw them
 *     myDraw.draw(c);
 *     // when done save it:
 *     myDraw.writeToFile("dumbCircle.png");
 * </pre>
 *
 * It should be noted that the 2-d locations might be a bit different than you're used to
 * (0,0) is the top-left corner, with increases in x going right and increases in y going down.
 */
public class ShapeDrawer {
    private final BufferedImage image;
    private final double maxX;
    private final double maxY;
    private final Graphics2D graphics;
    private Color stroke;
    private Color fill;

    /**
     * Create a new shape drawer that represents a new image
     * The default state of the image is all black, with all
     * shapes being draw with a green outline and grey fill.
     * (This is deliberately chosen as a somewhat ugly color theme.
     *  so you can easily notice code using default colors!)
     *
     *  The parameters indicate the largest x and y values in the drawing (with
     *  (0,0) being the smallest values). You can ask this object to draw larger
     *  or smaller positions, but they won't show up.
     * @param maxX the width of the canvas (the largest x value for drawing)
     * @param maxY the height of the canvas (the largest y value for drawing)
     */
    public ShapeDrawer(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.image = new BufferedImage((int)Math.ceil(maxX), (int)Math.ceil(maxY), TYPE_INT_RGB);
        this.graphics = image.createGraphics();

        // turn on anti-aliasing and set other "hints" to "favor quality over speed"
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
        graphics.setRenderingHints(rh);
        rh = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHints(rh);
        rh = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHints(rh);
        stroke = Color.green;
        fill = Color.gray;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,(int)Math.ceil(maxX), (int)Math.ceil(maxY));
    }

    /**
     * Change the color used when drawing the outline of a shape
     * @param stroke the new color. The type is java.awt.color.
     * For more information see: https://docs.oracle.com/javase/10/docs/api/java/awt/Color.html
     */
    public void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    /**
     * Change the color used when drawing the inside of a shape
     * @param fill the new color. The type is java.awt.color.
     * For more information see: https://docs.oracle.com/javase/10/docs/api/java/awt/Color.html
     */
    public void setFill(Color fill) {
        this.fill = fill;
    }
    
    /**
     * Draw a circle onto the shapeDrawer
     *
     * If other shapes have already been drawn, draw on top of those shapes.
     * 
     * */
    public void draw(Circle circle) {
        int x = (int) Math.round(circle.getCenter().getX());
        int y = (int) Math.round(circle.getCenter().getY());
        int r = (int) Math.round(circle.getRadius());
        
        int diameter = r * 2;
        
        graphics.setColor(fill);
        graphics.fillOval(x - r, y - r, diameter, diameter);
        graphics.setColor(stroke);
        graphics.drawOval(x - r, y - r, diameter, diameter);
        
    }

    public void draw(Ring ring) {
        int x = (int) Math.round(ring.getInnerCircle().getCenter().getX());
        int y = (int) Math.round(ring.getInnerCircle().getCenter().getY());
        int r = (int) Math.round(ring.getInnerCircle().getRadius());
        int t = (int) Math.round(ring.getThickness());

        int diameter = r * 2;
        graphics.setColor(fill);
        graphics.drawOval(x - r, y - r, diameter-t, diameter-t);
    }
    
    /**
     * Draw a point onto the shapeDrawer
     * A point will be represented as a small circle based on the stroke color.
     * */
    public void draw(Point point) {
        graphics.setColor(stroke);
        graphics.drawOval((int)point.getX(), (int)point.getY(), 1, 1);
        
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    /**
     * Save to a file.
     * @param fileName the name, or file path and name, of the file you want to make. This should end in ".png" since
     *                 This code asks Java to encode the image in png format.
     * @return The return value is a boolean. True indicates the image was written successfully. False indicates Failure.
     * If the image writing fails, often, but not always, there will be an error message printed as well.
     */
    public boolean writeToFile(String fileName) {
        try {
            return ImageIO.write(image, "png", new File(fileName));
        } catch (IOException e) {
            System.out.println("Saving to file failed.");
            e.printStackTrace();
            return false;
        }
    }
}
