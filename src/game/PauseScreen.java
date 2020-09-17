package game;

import animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Pause screen class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * @param d the d surface.
     * @param dt the dt
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * @return the boolean stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
