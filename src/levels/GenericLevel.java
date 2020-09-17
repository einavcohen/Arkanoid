package levels;

import geometry.Background;
import geometry.Block;
import geometry.Velocity;

import java.util.List;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Generic level.
 */
public class GenericLevel implements LevelInformation {

    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToClear;
    private Background backgroundSprite;
    private int numberOfBalls;


    /**
     * Sets velocities.
     *
     * @param velocities1 the velocities
     */
    public void setVelocities(List<Velocity> velocities1) {
        this.velocities = velocities1;
        numberOfBalls = velocities.size();
    }


    /**
     * Sets paddle speed.
     *
     * @param paddleSpeed1 the paddle speed
     */
    public void setPaddleSpeed(int paddleSpeed1) {
        this.paddleSpeed = paddleSpeed1;
    }


    /**
     * Sets paddle width.
     *
     * @param paddleWidth1 the paddle width
     */
    public void setPaddleWidth(int paddleWidth1) {
        this.paddleWidth = paddleWidth1;
    }


    /**
     * Sets level name.
     *
     * @param levelName1 the level name
     */
    public void setLevelName(String levelName1) {
        this.levelName = levelName1;
    }

    /**
     * Gets blocks.
     *
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Sets blocks.
     *
     * @param blocks1 the blocks
     */
    public void setBlocks(List<Block> blocks1) {
        this.blocks = blocks1;
    }


    /**
     * Sets number of blocks to clear.
     *
     * @param numberOfBlocksToClear1 the number of blocks to clear
     */
    public void setNumberOfBlocksToClear(int numberOfBlocksToClear1) {
        this.numberOfBlocksToClear = numberOfBlocksToClear1;
    }


    /**
     * Sets background sprite.
     *
     * @param backgroundSprite1 the background sprite
     */
    public void setBackgroundSprite(Background backgroundSprite1) {
        this.backgroundSprite = backgroundSprite1;
    }

    /**
     * @return int the num of the balls.
     */
    public int numberOfBalls() {
        return numberOfBalls;
    }


    @Override
    public List<Velocity> initialBallVelocities() {
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelName;
    }

    @Override
    public Background getBackground() {
        return this.backgroundSprite;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToClear;
    }
}
