package geometry;

/**
 * Collidable interface.
 * <p>
 * Notify the object that we collided with it at collisionPoint with
 * a given velocity.
 * The return is the new velocity expected after the hit (based on
 * the force the object inflicted on us).
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public interface Collidable {
    /**
     * getCollisionRectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit.
     *
     * @param hitter          hitter ball
     * @param collisionPoint  collision Point
     * @param currentVelocity current Velocity
     * @return the Velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}



