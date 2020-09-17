package geometry;

import game.GameEnvironment;
import game.HitListener;
import levels.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * ball class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Ball implements Sprite {
    private int r;
    private Point center;
    private Color c;
    private Velocity v;
    private int lowerBorder;
    private int topBoundary;
    private int rightWidth;
    private int leftWidth;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners = new ArrayList<>();

    //constructors

    /**
     * constructor.
     *
     * @param center      center point
     * @param r           radius
     * @param color       color
     * @param lowerBorder lower border
     * @param topBoundary top border
     * @param rightWidth  right border
     * @param leftWidth   left border
     */
    public Ball(Point center, int r, Color color, int lowerBorder, int topBoundary, int rightWidth, int leftWidth) {
        this.center = center;
        this.r = r;
        this.c = color;
        this.lowerBorder = lowerBorder;
        this.topBoundary = topBoundary;
        this.rightWidth = rightWidth;
        this.leftWidth = leftWidth;
    }

    /**
     * constructor.
     *
     * @param center          center point
     * @param r               radius
     * @param color           color
     * @param v               v
     * @param gameEnvironment gameEnvironment
     */
    public Ball(Point center, int r, Color color, Velocity v, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.c = color;
        this.v = v;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.c = color;
    }

    /**
     * Gets center.
     *
     * @return the center
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public int getRadius() {
        return r;
    }

    /**
     * timePassed
     * <p>
     * call move one step function.
     * @param dt the dt
     */
    public void timePassed(double dt) {
        moveOneStep(dt);
    }

    /**
     * Add to game.
     *
     * @param gameLevel gameLevel obj                  call addSprite function on the gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        this.gameEnvironment = gameLevel.getEnvironment();
        gameLevel.addSprite(this);
    }

    /**
     * set the velocity of the ball.
     * return new velocity.
     *
     * @param dx the dx val of velo.
     * @param dy the dy val of velo.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }


    /**
     * getter for x val of center point.
     *
     * @return x val.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * getter for y val for center point.
     *
     * @return y val.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * getter for the size of a ball.
     *
     * @return size of ball.
     */
    public int getSize() {
        return 3 * (this.r + this.r);
    }

    /**
     * getter for the color of a ball.
     *
     * @return color of ball.
     */
    public Color getColor() {
        return this.c;
    }


    /**
     * @param surface surface.
     *                draw the ball on the surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.c);
        surface.fillCircle(this.getX(), this.getY(), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * Sets center.
     *
     * @param center1 point center1 val                setter for the center point of a ball.
     */
    public void setCenter(Point center1) {
        this.center = center1;
    }

    /**
     * getter for the velocity of a ball.
     *
     * @return Velocity of ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * setter for the velocity of a ball.
     *
     * @param v1 velocity val.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * moveOneStep
     * <p>
     * changing the velocity of a ball according to his intersection with
     * a rectangle.
     * and move the ball by changing his center point.
     *
     * @param dt the dt
     */
    public void moveOneStep(double dt) {
        Velocity velocityAfterScale = this.v.scaleByDt(dt);
        Point endPoint = velocityAfterScale.applyToPoint(this.center);
        Line ballTrajectory = new Line(this.center, endPoint);

        CollisionInfo dataCollidable = gameEnvironment.getClosestCollision(ballTrajectory);
        if (dataCollidable != null) { //if null there is no collision
            Point collisionPoint = dataCollidable.collisionPoint();
            Collidable collisionObject = dataCollidable.collisionObject();
            Velocity velocity = collisionObject.hit(this, collisionPoint, this.getVelocity());
            this.setVelocity(velocity);
            velocityAfterScale = this.v.scaleByDt(dt);
            endPoint = velocityAfterScale.applyToPoint(this.center);
            this.center = endPoint;
        } else {
            this.center = endPoint;
        }
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

}
