package levels;

import animation.Animation;
import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.KeyPressStoppableAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.BlockRemover;
import geometry.Sprite;
import geometry.Point;
import game.ScoreIndicator;
import game.ScoreTrackingListener;
import game.LivesIndicator;
import game.HitListener;
import game.GameEnvironment;
import geometry.Paddle;
import geometry.ColorBackground;
import game.Counter;
import geometry.SpriteCollection;
import geometry.Ball;
import geometry.Block;
import game.BallRemover;
import geometry.Collidable;
import geometry.Rectangle;
import game.PauseScreen;

import java.util.ArrayList;
import java.awt.Color;

/**
 * GameLevel class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class GameLevel implements Animation {
    /**
     * The Width.
     */
    private static final int WIDTH = 800;
    /**
     * The Height.
     */
    private static final int HEIGHT = 600;
    private static final int BOUNDRYSIZE = 5;
    private boolean isRunning;
    private SpriteCollection sprites;
    private java.util.List<HitListener> blockLiseners = new ArrayList<>();
    private GameEnvironment environment;
    private Paddle paddle;
    private Counter counterBlocks;
    private Counter counterLives;
    private Counter counterScore;
    private Counter counterBalls;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private BlockRemover blockRemover;
    private boolean start = true;
    private KeyboardSensor keyboard;


    /**
     * Instantiates a new GameLevel.
     *
     * @param levelInfo  the level info
     * @param keyboard   the keyboard
     * @param animationR the animation r
     * @param currLives  the curr lives
     * @param currScore  the curr score
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboard, AnimationRunner animationR,
                     Counter currLives, Counter currScore) {
        //runner = new AnimationRunner(60);
        this.running = false;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        //counterLives = new Counter(7);
        // counterBlocks = new Counter(0);
        // counterScore = new Counter(0);
        counterBalls = new Counter(0);
        this.levelInformation = levelInfo;
        this.keyboard = keyboard;
        this.runner = animationR;
        this.counterLives = currLives;
        this.counterScore = currScore;
        this.counterBlocks = new Counter(this.levelInformation.numberOfBlocksToRemove());

    }

    /**
     * add the collidables to the env.
     *
     * @param c the collidable obj.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add the sprite to the sprites obj.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.getCollidObjects().remove(c);
    }


    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * initialize the game.
     */
    public void initialize() {

        blockRemover = new BlockRemover(this, counterBlocks);


        this.blockLiseners.add(blockRemover);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(counterScore);
        this.blockLiseners.add(scoreTrackingListener);
        BallRemover ballRemover = new BallRemover(this, counterBalls);
        ScoreIndicator scoreIndicator = new ScoreIndicator(counterScore);

        LivesIndicator livesIndicator = new LivesIndicator(counterLives);

        this.sprites.addSprite(levelInformation.getBackground());
        Block[] frameBlocks = new Block[4];

        frameBlocks[0] = new Block(new Rectangle(new Point(0, 25),
                800, BOUNDRYSIZE), new ColorBackground(Color.MAGENTA, 0, 25, BOUNDRYSIZE, 800));
        frameBlocks[1] = new Block(new Rectangle(new Point(0, 25),
                BOUNDRYSIZE, 600), new ColorBackground(Color.GREEN,
                0, 25, 600, BOUNDRYSIZE));
        frameBlocks[2] = new Block(new Rectangle(new Point(0, 600),
                800, BOUNDRYSIZE), new ColorBackground(Color.CYAN, 0, 595, BOUNDRYSIZE, 800));
        frameBlocks[3] = new Block(new Rectangle(new Point(795, 25),
                BOUNDRYSIZE, 600), new ColorBackground(Color.RED, 795, 25, 600, BOUNDRYSIZE));

        for (int i = 0; i < 4; i++) {
            frameBlocks[i].addToGame(this);
            if (i == 2) {
                this.sprites.removeSprite(frameBlocks[i]);
            }
        }

        frameBlocks[2].addHitListener(ballRemover);
        addCollidable(frameBlocks[2]);

        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            for (HitListener h : this.blockLiseners) {
                block.addHitListener(h);
            }
        }

        paddle = new Paddle(new Rectangle(new Point(250, 585),
                levelInformation.paddleWidth(), 10), Color.BLACK,
                runner.getKeyboardSensor(), levelInformation.paddleSpeed());
        paddle.addToGame(this);
        paddle.setBounds(BOUNDRYSIZE, WIDTH - BOUNDRYSIZE);
        Sprite levelNameBar = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.drawText(550, 20, "Level Name:" + levelInformation.levelName(), 20);
            }

            @Override
            public void timePassed(double dt) {
                // Nothing to do.
            }
        };
        this.addSprite(scoreIndicator);
        this.addSprite(levelNameBar);
        this.addSprite(livesIndicator);

    }

    /**
     * Create balls on top of paddle.
     */
    public void createBallsOnTopOfPaddle() {
        int xForPaddle = 400 - (levelInformation.paddleWidth() / 2);
        paddle.setUpper(new Point(xForPaddle, 585));
        int x = (int) this.paddle.getCollisionRectangle().getTopLineRectangle().middle().getX();
        int y = (int) this.paddle.getCollisionRectangle().getTopLineRectangle().middle().getY() - 15;
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(x, y), 4, Color.GRAY,
                    levelInformation.initialBallVelocities().get(i), environment);
            ball.addToGame(this);
            counterBalls.increase(1);
        }
    }

    /**
     * Run.
     */
    public void run() {

        do {
            playOneTurn();
            if (counterBlocks.getValue() <= 0) {
                counterScore.increase(100);
                break;
            }
            if (counterBlocks.getValue() > 0 && counterBalls.getValue() == 0) {
                this.counterLives.decrease(1);
            }

        } while (this.counterLives.getValue() > 0);

    }

    /**
     * run the game -- start the animation loop.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle();
        this.running = true;
        this.runner.run(this);
    }

    /**
     * @return bollean running.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @param d   the d.
     * @param dt1 the dt val.
     */
    public void doOneFrame(DrawSurface d, double dt1) {
        if (start) {
            this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
            start = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard)));
            this.runner.run(new CountdownAnimation(2, 3, sprites)); // countdown before turn starts.
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt1);

        if (counterBlocks.getValue() <= 0) {
            counterScore.increase(100);
            running = false;
        }
        if (counterBalls.getValue() <= 0) {
            counterLives.decrease(1);
            running = false;

        }

    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.counterBlocks;
    }
}


