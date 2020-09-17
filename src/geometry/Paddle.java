package geometry;

import levels.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * paddle class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private final int parts = 7;
    private static final int STEP = 10;
    private int lbound;
    private int rbound;
    private int speed;
    private double framedt = 60;
    private double dt = 1 / framedt;

    // constructors

    /**
     * first constructor of line.
     *
     * @param rectangle the rect
     * @param color     color
     * @param keyboard  keyboard
     * @param speed     the speed
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
        this.lbound = -1;
        this.rbound = -1;
    }

    /**
     * Sets bounds.
     *
     * @param lbound1 the lbound 1
     * @param rbound1 the rbound 1
     */
    public void setBounds(int lbound1, int rbound1) {
        this.lbound = lbound1;
        this.rbound = rbound1;
    }

    /**
     * Add this paddle to the gameLevel.
     *
     * @param gameLevel gameLevel
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * setter for the upperLeft point.
     *
     * @param upperLeft upperLeft point
     */
    public void setUpper(Point upperLeft) {
        this.rectangle.setUpperLeft(upperLeft);
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);

    }

    /**
     * move the paddle to rhe left side.
     *
     * @param dt1 the dt
     */
    public void moveLeft(double dt1) {
        if (lbound < 0) {
            return;
        }

        if (this.rectangle.getUpperLeft().getX() - STEP > lbound) {
            this.setUpper(new Point(this.rectangle.getUpperLeft().getX() - speed * dt,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    /**
     * move the paddle to rhe right side.
     *
     * @param dt1 the dt val
     */
    public void moveRight(double dt1) {
        if (this.rbound < 0) {
            return;
        }
        if (this.rectangle.getUpperLeft().getX() + STEP + this.rectangle.getWidth() < rbound) {
            this.setUpper(new Point(this.rectangle.getUpperLeft().getX() + speed * dt,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    // Sprite

    /**
     * call a funcs that move the paddle according to the choice of the user.
     * @param dt1 the dt val
     */
    public void timePassed(double dt1) {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft(dt);
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight(dt);
        }
    }

    /**
     * draw the paddle on the surface.
     *
     * @param d the surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.white);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());

    }

    // Collidable

    /**
     * getter for the collision rect.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * check where the collision point and change the velocity of the ball according to this.
     *
     * @param collisionPoint  collision Point
     * @param currentVelocity current Velocity
     * @param hitter          hitter ball
     * @return Velocity new velo
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double paddleParts = (rectangle.getWidth()) / parts;
        double part1 = this.rectangle.getUpperLeft().getX() + paddleParts;
        double part2 = part1 + paddleParts;
        double part3 = part2 + paddleParts;
        double part4 = part3 + paddleParts;
        double part5 = part4 + paddleParts;
        double part6 = part5 + paddleParts;
        double part7 = part6 + paddleParts;
        double speed1 = Math.sqrt((currentVelocity.getDX()
                * currentVelocity.getDX()) + (currentVelocity.getDY() * currentVelocity.getDY()));

        // p1
        if (collisionPoint.getX() >= 0 && collisionPoint.getX() <= part1) {
            return Velocity.fromAngleAndSpeed(300, speed1);
        }

        // p2
        if (collisionPoint.getX() > part1 && collisionPoint.getX() <= part2) {
            return Velocity.fromAngleAndSpeed(320, speed1);
        }
        // p3
        if (collisionPoint.getX() > part2 && collisionPoint.getX() <= part3) {
            return Velocity.fromAngleAndSpeed(340, speed1);
        }
        // p4
        if (collisionPoint.getX() > part3 && collisionPoint.getX() <= part4) {
            return Velocity.fromAngleAndSpeed(0, speed1);
        }

        if (collisionPoint.getX() > part4 && collisionPoint.getX() <= part5) {
            return Velocity.fromAngleAndSpeed(20, speed1);
        }

        if (collisionPoint.getX() > part5 && collisionPoint.getX() <= part6) {
            return Velocity.fromAngleAndSpeed(40, speed1);
        }

        // p7
        return Velocity.fromAngleAndSpeed(60, speed1);
    }

}
