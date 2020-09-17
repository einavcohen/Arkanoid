package geometry;

import game.HitListener;
import game.HitNotifier;
import levels.GameLevel;
import biuoop.DrawSurface;


import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Block class.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Map<Integer, Background> hitPointsToBackgrounds;
    private int hitPoints;
    private List<HitListener> listeners;
    private Color stroke;


    /**
     * Instantiates a new Block.
     *
     * @param rectangle       the rectangle
     * @param colorBackground the color background
     */
    public Block(Rectangle rectangle, ColorBackground colorBackground) {
        this.listeners = new ArrayList<>();
        this.hitPointsToBackgrounds = new HashMap<>();
        this.rectangle = rectangle;
        this.hitPointsToBackgrounds.put(-1, colorBackground);
        this.stroke = Color.BLACK;
        this.hitPoints = -1;
    }

    /**
     * Instantiates a new Block.
     *
     * @param rectangle  the rectangle
     * @param hitPoints  the hit points
     * @param background the background
     */
//
    public Block(Rectangle rectangle, int hitPoints, Background background) {
        this.listeners = new ArrayList<>();
        this.hitPointsToBackgrounds = new HashMap<>();
        this.rectangle = rectangle;
        this.hitPointsToBackgrounds.put(-1, background);
        this.stroke = Color.BLACK;
        this.hitPoints = hitPoints;
    }
    ///


    /**
     * Sets stroke.
     *
     * @param stroke1 the stroke
     */
    public void setStroke(Color stroke1) {
        this.stroke = stroke1;
    }

    /**
     * Sets hit points to backgrounds.
     *
     * @param hitPointsToBackgrounds1 the hit points to backgrounds
     */
    public void setHitPointsToBackgrounds(Map<Integer, Background> hitPointsToBackgrounds1) {
        this.hitPointsToBackgrounds = hitPointsToBackgrounds1;
    }

    /**
     * Instantiates a new Block.
     *
     * @param x         the x
     * @param y         the y
     * @param width     the width
     * @param height    the height
     * @param hitPoints the hit points
     */
    public Block(int x, int y, int width, int height, int hitPoints, Color stroke) {
        this.listeners = new ArrayList<>();
        this.rectangle = new Rectangle(new Point((double) x, (double) y), (double) width, (double) height);
        this.hitPoints = hitPoints;
        this.listeners = new ArrayList<>();
        this.stroke = stroke;
    }
    //        this.stroke = Color.BLACK;
    //        this.listeners = new ArrayList<>();
    //        this.hitPoints = hitPoints;
    //        this.color = bg;
    //        this.rectangle = new Rectangle(new Point((double) x, (double) y), (double) width, (double) height);
    //    public Block(int x, int y, int width, int height, int hitPoints, Color bg) {
    //     */
    //     * @param bg        the bg
    //     * @param hitPoints the hit points
    //     * @param height    the height
    //     * @param width     the width
    //     * @param y         the y
    //     * @param x         the x
    //     *
    //     * Instantiates a new Block.
    //    /**
    //
    //    }
    //        this.stroke = Color.BLACK;
    //        this.color = color;
    //        this.rectangle = rectangle;
    //    public Block(Rectangle rectangle, Color color) {
    //     */
    //     * @param color     color of block.
    //     * @param rectangle rectangle shape.
    //     *
    //     * constructor.
//    /**

//    }

//    /**
//     * Instantiates a new Block.
//     *
//     * @param x         the x
//     * @param y         the y
//     * @param width     the width
//     * @param height    the height
//     * @param hitPoints the hit points
//     * @param bg        the bg
//     * @param stroke1   the stroke 1
//     */
//    public Block(int x, int y, int width, int height, int hitPoints, Sprite bg, Color stroke1) {
//        this.rectangle = new Rectangle(new Point((double) x, (double) y), (double) width, (double) height);
//        this.hitPointsToBackgrounds.put(-1,bg);
//        this.hitPoints = hitPoints;
//        this.listeners = new ArrayList<>();
//        this.stroke = stroke1;
//    }


    /**
     * timePassed.
     * <p>
     * timePassed function.
     *
     * @param dt the dt
     */
    public void timePassed(double dt) {

    }

    /**
     * addToGame.
     *
     * @param gameLevel gameLevel obj                  add the collidable obj and the sprite obj
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }


    /**
     * drawOn.
     *
     * @param surface surface.
     *                draw a block on the surface.
     *                and draw a text on it.
     */
    public void drawOn(DrawSurface surface) {
        if (this.hitPointsToBackgrounds.containsKey(this.hitPoints)) {
            Background b =  this.hitPointsToBackgrounds.get(this.hitPoints);
            b.drawOn(surface);
        } else {
            this.hitPointsToBackgrounds.get(-1).drawOn(surface);
        }
        if(this.stroke != null) {
            surface.setColor(this.stroke);
            surface.drawRectangle((int) rectangle.getUpperLeft().getX(),
                    (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(),
                    (int) rectangle.getHeight());
        }

    }

    /**
     * getter for the rectangle.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * hit function change the velocity of a ball according to the move.
     *
     * @param collisionPoint  the collision point.
     * @param currentVelocity current Velocity of the ball.
     * @param hitter          hitter ball.
     * @return Velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDX();
        double dy = currentVelocity.getDY();
        this.hitPoints--;
        if (this.rectangle.getTopLineRectangle().isInLine(collisionPoint)
                || this.rectangle.getBottomLineRectangle().isInLine(collisionPoint)) {
            dy *= -1;
        }
        if (this.rectangle.getLeftLineRect().isInLine(collisionPoint)
                || this.rectangle.getRightLineRectangle().isInLine(collisionPoint)) {
            dx *= -1;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * Gets numt hit points.
     *
     * @return the numt hit points
     */
    public int getNumtHitPoints() {
        return this.hitPoints;
    }


    /**
     * addHitListener func.
     *
     * @param hl the hl
     */
    public void addHitListener(HitListener hl) {
        listeners.add(hl);
    }

    /**
     * removeHitListener func.
     *
     * @param hl the hl
     */
    public void removeHitListener(HitListener hl) {
        if (this.listeners.contains(hl)) {
            listeners.remove(hl);
        }
    }

    /**
     * notifyHit func.
     *
     * @param hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners1 = new ArrayList<HitListener>(this.listeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners1) {
            hl.hitEvent(this, hitter);
        }
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
}


