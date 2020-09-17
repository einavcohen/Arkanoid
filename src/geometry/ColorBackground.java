package geometry;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Color background.
 */
public class ColorBackground extends Background {

    private Color color;

    /**
     * setX function.
     * @param x the x val
     */
    public void setX(int x) {
        super.setX(x);
    }

    /**
     * setY function.
     * @param y the y val
     */
    public void setY(int y) {
        super.setY(y);
    }

    /**
     * setHeight function.
     * @param height the height val
     */
    public void setHeight(int height) {
        super.setHeight(height);
    }

    /**
     * setWidth function.
     * @param width1 the width val
     */
    public void setWidth(int width1) {
        super.setWidth(width1);
    }

    /**
     * Instantiates a new Color background.
     *
     * @param color1  the color 1
     * @param x       the x
     * @param y       the y
     * @param height1 the height 1
     * @param width1  the width 1
     */
    public ColorBackground(Color color1, int x, int y, int height1, int width1) {
        super(x, y, height1, width1);
        super.setColor(color1);
    }

    /**
     * Instantiates a new Color background.
     *
     * @param color1 the color 1
     */
    public ColorBackground(Color color1) {
        super();
        this.color = color1;
    }

/**
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(super.getX(), super.getY(), super.getHeight(), super.getWidth());
    }
**/
    @Override
    public void timePassed(double dt) {
    }

    /**
     * getColor function.
     * @return color.
     */
    public Color getColor() {
        return color;
    }
}
