import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * This class has utilities (static functions) for reading and writing RGBImages from a file.
 * In theory -- these could be functions in RGBImage, but by putting them here we seperate _these_ complexities
 * from the difficulty of representing an image directly.
 */
public class RGBImageUtil {
    /**
     * Read an image from a file.
     * @param filename the name and location of the file.
     * @return the image
     * @throws RuntimeException -- crashes the code if the file can't be read.
     */
    public static RGBImage load(String filename) {
        // Step 1: load image using standard java libraries.
        BufferedImage img = null;
        try {
            String fullpath = Paths.get(filename).toAbsolutePath().toString();
            System.out.println("Attempting to read file: "+fullpath);
            img = ImageIO.read(new File(fullpath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot Load image. See caused by: message for full description", e);
        }

        // Step 2: the standard java libraries can be *a lot* to handle. Simplify by putting it into a RGBColor array
        int width = img.getWidth();
        int height = img.getHeight();
        RGBColor[][] image = new RGBColor[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                java.awt.Color c = new java.awt.Color(img.getRGB(x, y));
                RGBColor color = new RGBColor(c.getRed(), c.getGreen(), c.getBlue());
                image[x][y] = color;
            }
        }
        // Step 3: make a RGBImage to represent things at the end!
        return new RGBImage(image);
    }

    /**
     * Freezes the program to show you an image. Useful in debugging!
     * (Note -- this may, or may not, work on your computer, or in your environment.
     * I recommend trying it out.)
     */
    public static void showImage(RGBImage img) {
        showImage(getBI(img));
    }

    /**
     * Save an image
     * @param img the image to save
     * @param filename the filename and location to save to NOTE: this must be a .png file. and must end with .png
     */
    public static void saveImage(RGBImage img, String filename) {
        try {
            BufferedImage bi = getBI(img);
            String fullpath = Paths.get(filename).toAbsolutePath().toString();
            System.out.println("Attempting to write to file: " + fullpath);
            File file = new File(fullpath);
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save image, see caused by message for full description", e);
        }
    }

    /**
     * helper image for converting between RGBImage and more standard java object representations
     * @param img
     * @return
     */
    private static BufferedImage getBI(RGBImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                RGBColor color = img.getColor(x, y);
                java.awt.Color c = new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
                bi.setRGB(x, y, c.getRGB());
            }
        }
        return bi;
    }

    /**
     * The actual _hard work_ of showing an image
     * Mostly based on the work of:
     * http://www.java2s.com/example/java-utility-method/bufferedimage-show/showimage-bufferedimage-img-8be34.html
     * Original source seems to be Christopher Collin Hall
     */
    private static void showImage(BufferedImage img) {
        JLabel ic = new JLabel(new ImageIcon(img));
        JScrollPane scroller = new JScrollPane(ic);
        JDialog popup = new JDialog();
        popup.getContentPane().setLayout(new FlowLayout());
        popup.getContentPane().add(scroller);
        popup.getContentPane().validate();
        popup.setModal(true);
        popup.pack();
        popup.setVisible(true);
        popup.dispose();
    }
}
