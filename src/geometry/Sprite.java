package geometry;

import biuoop.DrawSurface;

/**
 * draw the sprite to the screen.
 * notify the sprite that time has passed.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public interface Sprite {
    /**
     * Draw on.
     *
     * @param d the surface.
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed func.
     *
     * @param dt the dt
     */
    void timePassed(double dt);
}



