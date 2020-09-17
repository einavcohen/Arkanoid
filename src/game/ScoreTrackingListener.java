package game;


import geometry.Ball;
import geometry.Block;

/**
 * Score tracking listener class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hitEvent function.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getNumtHitPoints() >= 1) {
            currentScore.increase(5);
        }
        if (beingHit.getNumtHitPoints() < 1) {
            currentScore.increase(10);
        }
    }
}