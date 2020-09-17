package game;

import geometry.Collidable;
import geometry.CollisionInfo;
import geometry.Line;
import geometry.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * GameEnvironment class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class GameEnvironment {

    //creat an array list of collidable obj.
    private List<Collidable> collidObjects = new ArrayList<>();

    /**
     * Gets collid objects.
     *
     * @return the collid objects
     */
    public List<Collidable> getCollidObjects() {
        return collidObjects;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the collidable obj
     */
    public void addCollidable(Collidable c) {
        this.collidObjects.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.collidObjects.remove(c);
    }

    /**
     * getClosestCollision
     * <p>
     * find the closest min collision point of a ball and collidable obj,
     * and find the the collidable object  that collid in that point.
     * <p>
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory of the ball
     * @return CollisionInfo collision point and the collid obj .
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point temp;
        CollisionInfo collided = null;
        List<CollisionInfo> collides = new ArrayList<CollisionInfo>();
        for (int i = 0; i < collidObjects.size(); i++) {
            Collidable b = collidObjects.get(i);
            if (!b.getCollisionRectangle().intersectionPoints(trajectory).isEmpty()) {
                temp = trajectory.closestIntersectionToStartOfLine(b.getCollisionRectangle());
                collides.add(new CollisionInfo(temp, b));
            }
        }
        if (!collides.isEmpty()) {
            double dstTemp, midDst;
            collided = collides.get(0);
            midDst = collided.collisionPoint().distance(trajectory.start());
            for (int i = 1; i < collides.size(); i++) {
                dstTemp = collides.get(i).collisionPoint().distance(trajectory.start());
                if (dstTemp < midDst) {
                    collided = collides.get(i);
                }
            }
        }
        return collided;
    }
}




