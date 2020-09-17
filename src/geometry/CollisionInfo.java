package geometry;

/**
 * CollisionInfo class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class CollisionInfo {

    private Point collision;
    private Collidable collidObj;

    /**
     * constructor.
     *
     * @param collision the collision point
     * @param collidObj the collid obj
     */
    public CollisionInfo(Point collision, Collidable collidObj) {
        this.collision = collision;
        this.collidObj = collidObj;
    }

    /**
     * the point at which the collision occurs.
     *
     * @return the collision Point
     */
    public Point collisionPoint() {
        this.collision = collision;
        return collision;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return the Collidable object.
     */
    public Collidable collisionObject() {
        this.collidObj = collidObj;
        return collidObj;
    }

}

