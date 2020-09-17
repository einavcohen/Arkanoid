package geometry;

import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Image;
/**
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Background.
 */
public class Background implements Sprite {
    private int x;
    private int y;
    private int height;
    private int width;
    private Image image;

    /**
     * Sets color.
     *
     * @param color1 the color
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    private Color color;

    /**
     * Instantiates a new Background.
     */
    public Background() {
    }

    /**
     * background function.
     *
     * @param background the background
     */
    public Background(Background background) {
        this.x = background.x;
        this.y = background.y;
        this.height = background.height;
        this.width = background.width;
        this.color = background.color;
        this.image = background.image;
    }

    /**
     * Instantiates a new Background.
     *
     * @param x      the x
     * @param y      the y
     * @param height the height
     * @param width  the width
     */
    public Background(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Instantiates a new Background.
     *
     * @param c the c
     */
    public Background(Color c) {
        this.color = c;
    }

    /**
     * Instantiates a new Background.
     *
     * @param i the
     */
    public Background(Image i) {
        this.image = i;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height1 the height
     */
    public void setHeight(int height1) {
        this.height = height1;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width1 the width 1
     */
    public void setWidth(int width1) {
        this.width = width1;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x1 the x 1
     */
    public void setX(int x1) {
        this.x = x1;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y1 the y 1
     */
    public void setY(int y1) {
        this.y = y1;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (this.image != null) {
            d.drawImage(x, y, image);
        } else {
            d.setColor(color);
            d.fillRectangle(x, y, width, height);
        }
    }

    @Override
    public void timePassed(double dt) {

    }
}
