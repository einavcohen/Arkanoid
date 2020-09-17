package game;

import biuoop.DrawSurface;
import geometry.Sprite;

import java.awt.Color;

/**
 * Lives indicator class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

    /**
     * Instantiates a new Lives indicator.
     *
     * @param lives the lives
     */
    public LivesIndicator(Counter lives) {
        this.lives = lives;
    }

    /**
     * draw the sprite to the screen.
     * notify the sprite that time has passed.
     *
     * @author Einav Cohen
     * @version 24 April 2018
     */

    /**
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(100, 20, "Lives:" + String.valueOf(lives.getValue()), 18);
    }

    /**
     * timePassed func.
     * @param dt the dt
     */
    public void timePassed(double dt) {

    }


}
