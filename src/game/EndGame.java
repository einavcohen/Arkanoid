package game;

import animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * End game class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class EndGame implements Animation {

    private final boolean isWin;
    private Counter score;
    private KeyboardSensor keyboard;
    private Counter numberOfLives;
    private boolean stop;

    /**
     * Instantiates a new End screen.
     *
     * @param keyboard the keyboard
     * @param score    the score
     * @param isWin2   the is win 2
     */
    public EndGame(KeyboardSensor keyboard, Counter score, boolean isWin2) {
        this.keyboard = keyboard;
        this.score = score;
        this.isWin = isWin2;
        this.stop = false;
    }

    /**
     * draw one frame of he animation.
     * @param d  the drawsurface
     * @param dt the dt
     */
    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.black);

        if (this.isWin) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "game Over. Your score is " + this.score.getValue(), 32);
        }
    }

    /**
     * checks the stop condition for the animation.
     *
     * @return true if the animation should run, else false
     */
    @Override
    public boolean shouldStop() {
        return false;
    }

}
