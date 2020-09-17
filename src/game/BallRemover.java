package game;


import geometry.Ball;
import geometry.Block;
import levels.GameLevel;

/**
 * Ball remover class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel    the game level
     * @param removedBalls the removed balls
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }


    /**
     * Blocks that are hit and reach 0 hit-points should be removed
     * from the gameLevel. Remember to remove this listener from the block
     * that is being removed from the gameLevel.
     *
     * @param beingHit beingHit block.
     * @param hitter   hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //beingHit.getCollisionRectangle().getUpperLeft().getY() == 595.0
        if (remainingBalls.getValue() > 0) {
            hitter.removeFromGame(gameLevel);
            remainingBalls.decrease(1);
        }
    }

}
