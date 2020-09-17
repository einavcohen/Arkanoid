package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The animation runner class.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
public class AnimationRunner {
    /**
     * The Framedt.
     */
    private static final double FRAMEDT = 60;
    /**
     * The Height.
     */
    private static final int HEIGHT = 600;
    /**
     * The Width.
     */
    private static final int WIDTH = 800;
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Instantiates a new animation runner.
     *
     * @param gui2            the gui 2
     * @param framesPerSecond the frames per second
     */
    public AnimationRunner(GUI gui2, int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
        framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.gui = gui2;
    }

    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper1 = new Sleeper();

        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            double dt = 1 / FRAMEDT;
            animation.doOneFrame(d, dt);
            if (animation.shouldStop()) {
                break;
            }
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Get keyboard sensor biuoop . keyboard sensor.
     *
     * @return the biuoop . keyboard sensor
     */
    public biuoop.KeyboardSensor getKeyboardSensor() {
        return this.gui.getKeyboardSensor();
    }


}
