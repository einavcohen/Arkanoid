package game;
import geometry.Ball;
import geometry.Block;

/**
 * The interface Hit listener.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public interface HitListener {
    /**
     * Hit event.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
// This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    void hitEvent(Block beingHit, Ball hitter);
}

