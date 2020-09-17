package animation;

import biuoop.DrawSurface;
import geometry.SpriteCollection;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

/**
 * CountdownAnimation class.
 * <p>
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) secods, before
 * it is replaced with the next one.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Long previousUpdateTime = null;
    private int currentTimeOfDisplay;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.currentTimeOfDisplay = countFrom;
    }

    /**
     * @param d  the d surface.
     * @param dt the dt.
     */
    public void doOneFrame(DrawSurface d, double dt) {
        if (previousUpdateTime == null) {
            this.previousUpdateTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        long curTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (curTime - previousUpdateTime >= 1) {
            currentTimeOfDisplay -= 1;
            this.previousUpdateTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        if (countFrom - currentTimeOfDisplay >= numOfSeconds + 1) {
            stop = true;
            currentTimeOfDisplay += 1;
        }
        //background
        this.gameScreen.drawAllOn(d);
        //display timer
        d.setColor(Color.white);
        int size = 50;
        d.drawText((d.getWidth() / 2), (d.getHeight() / 2), "" + (currentTimeOfDisplay), size);
    }

    /**
     * @return boolean stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
