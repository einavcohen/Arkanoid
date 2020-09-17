package game;


import geometry.Ball;
import geometry.Block;

/**
 * The class Printing hit listener.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class PrintingHitListener implements HitListener {
    /**
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getNumtHitPoints() + " points was hit.");
    }
}
