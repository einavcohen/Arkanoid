package game;

import geometry.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * Score indicator class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class ScoreIndicator implements Sprite {
    private Counter counterIndicator;

    /**
     * Instantiates a new Score indicator.
     *
     * @param counterIndicator the counter indicator
     */
    public ScoreIndicator(Counter counterIndicator) {
        this.counterIndicator = counterIndicator;
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
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, 800, 25);

        d.setColor(Color.black);
        d.drawText(300, 20, "Score:" + String.valueOf(counterIndicator.getValue()), 18);
    }

    /**
     * timePassed func.
     * @param dt the dt
     */
    public void timePassed(double dt) {

    }

}



