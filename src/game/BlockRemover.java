package game;


import geometry.Ball;
import geometry.Block;
import levels.GameLevel;

/**
 * Block remover class.
 * <p>
 * a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    private HitListener hitListener;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel     the game level
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
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
        if (beingHit.getNumtHitPoints() == 0) {
            beingHit.removeFromGame(gameLevel);
            remainingBlocks.decrease(1);
            beingHit.removeHitListener(hitListener);
        }
    }

}


