package game;

import java.io.Serializable;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Score info.
 */
public class ScoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name1;
    private int score1;

    /**
     * Instantiates a new Score info.
     *
     * @param name  the name
     * @param score the score
     */
    public ScoreInfo(String name, int score) {
        this.name1 = name;
        this.score1 = score;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name1;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score1;
    }


}
