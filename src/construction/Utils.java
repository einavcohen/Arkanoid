package construction;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Utils.
 */
public class Utils {
    /**
     * Color from string java . awt . color.
     *
     * @param s the s
     * @return the java . awt . color
     */
// parse color definition and return the specified color.
    public static java.awt.Color colorFromString(String s) {
        if (s.equals("black")) {
            return Color.black;
        }
        if (s.equals("blue")) {
            return Color.blue;
        }
        if (s.equals("cyan")) {
            return Color.cyan;
        }
        if (s.equals("gray")) {
            return Color.gray;
        }
        if (s.equals("lightGray")) {
            return Color.lightGray;
        }
        if (s.equals("green")) {
            return Color.green;
        }
        if (s.equals("orange")) {
            return Color.orange;
        }
        if (s.equals("pink")) {
            return Color.pink;
        }
        if (s.equals("red")) {
            return Color.red;
        }
        if (s.equals("white")) {
            return Color.white;
        }
        if (s.equals("yellow")) {
            return Color.yellow;
        }
        return Color.BLACK;
    }

    /**
     * Get image from path image.
     *
     * @param path the path
     * @return the image
     */
    public static Image getImageFromPath(String path) {
        InputStream is;
        BufferedImage img = null;

        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}