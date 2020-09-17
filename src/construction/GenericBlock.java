package construction;
import geometry.Background;
import geometry.Block;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Generic block.
 */
public class GenericBlock {

    private int height;
    private int width;
    private int hitPoints;
    private Color stroke;
    private Map<Integer, Background> hitsToBackground;

    /**
     * Instantiates a new Generic block.
     */
    public GenericBlock() {
        this.hitsToBackground = new HashMap<>();
        stroke = null;
    }

    /**
     * Create block.
     *
     * @param xpos the xpos
     * @param ypos the ypos
     * @return the block
     */
    Block create(int xpos, int ypos) {
        Map<Integer, Background> copyMap = new HashMap<>();

        for (Integer hitNum : this.hitsToBackground.keySet()) {
            Background backgroundCopy = new Background(this.hitsToBackground.get(hitNum));
            copyMap.put(hitNum, backgroundCopy);
        }

        for (Background bg : copyMap.values()) {
            bg.setHeight(this.height);
            bg.setWidth(this.width);
            bg.setX(xpos);
            bg.setY(ypos);
        }

        //change here
        //Rectangle rec = new Rectangle(new Point(xpos,ypos),(double)this.width, (double)this.height);
        Block b = new Block(xpos, ypos, this.width, this.height, this.hitPoints, this.stroke);
        b.setHitPointsToBackgrounds(copyMap);
        //b.setStroke(this.stroke);

        return b;
    }

    /**
     * Copy generic block.
     *
     * @return the generic block
     */
    public GenericBlock copy() {
        GenericBlock bc = new GenericBlock();
        bc.height = this.height;
        bc.hitPoints = this.hitPoints;
        bc.hitsToBackground = new HashMap<>();
        for(Map.Entry<Integer, Background> entry : this.hitsToBackground.entrySet()) {
            bc.hitsToBackground.put(entry.getKey(), entry.getValue());
        }
        //bc.hitsToBackground = this.hitsToBackground;
        bc.stroke = this.stroke;
        bc.width = this.width;
        return bc;
    }

    /**
     * Sets height.
     *
     * @param height1 the height
     */
    public void setHeight(int height1) {
        this.height = height1;
    }

    /**
     * Sets width.
     *
     * @param width1 the width
     */
    public void setWidth(int width1) {
        this.width = width1;
    }

    /**
     * Sets hit points.
     *
     * @param hitPoints1 the hit points 1
     */
    public void setHitPoints(int hitPoints1) {
        this.hitPoints = hitPoints1;
    }

    /**
     * Sets stroke.
     *
     * @param stroke1 the stroke 1
     */
    public void setStroke(Color stroke1) {
        this.stroke = stroke1;
    }

    /**
     * Gets hits to background.
     *
     * @return the hits to background
     */
    public Map<Integer, Background> getHitsToBackground() {
        return hitsToBackground;
    }


}
