package geometry;

import biuoop.DrawSurface;

import java.awt.Image;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Image background.
 */
public class ImageBackground extends Background implements Sprite {
    private Image img;

    /**
     * setX function.
     *
     * @param x the x val.
     */
    public void setX(int x) {
        super.setX(x);
    }

    /**
     * setY function.
     *
     * @param y the y val.
     */
    public void setY(int y) {
        super.setY(y);
    }

    /**
     * Instantiates a new Image background.
     *
     * @param img1 the img 1
     * @param x    the x
     * @param y    the y
     */
    public ImageBackground(Image img1, int x, int y) {
        super(x, y, 0, 0);
        this.img = img1;
    }

    /**
     * Instantiates a new Image background.
     *
     * @param img1 the img 1
     */
    public ImageBackground(Image img1) {
        super();
        this.img = img1;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage(super.getX(), super.getY(), img);
    }

    @Override
    public void timePassed(double dt) {
    }
}
