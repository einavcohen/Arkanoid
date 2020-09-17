package geometry;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * SpriteCollection class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class SpriteCollection {

    private List<Sprite> spriteObject = new ArrayList<>();


    /**
     * Gets sprite list.
     *
     * @return the sprite list
     */
    public List<Sprite> getSpriteList() {
        return spriteObject;
    }

    /**
     * addSprite func.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.spriteObject.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.spriteObject.remove(s);
    }

    /**
     * notifyAllTimePassed func.
     * call timePassed() on all sprites.
     *
     * @param dt the dt
     */
    public void notifyAllTimePassed(double dt) {

        for (int i = 0; i < spriteObject.size(); i++) {
            spriteObject.get(i).timePassed(dt);
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d draw the surface.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> newList = new ArrayList<>(spriteObject);
        for (int i = 0; i < newList.size(); i++) {
            newList.get(i).drawOn(d);
        }
    }

}

