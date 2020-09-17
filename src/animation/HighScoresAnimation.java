package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.HighScoresTable;
import game.ScoreInfo;
import java.awt.Color;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type High scores animation.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable scores1;
    private String endKey1;
    private KeyboardSensor keyboardSensor;
    private boolean stopped;

    /**
     * Instantiates a new High scores animation.
     *
     * @param scores          the scores
     * @param endKey          the end key
     * @param keyboardSensor1 the keyboard sensor 1
     */
    public HighScoresAnimation(HighScoresTable scores, String endKey, KeyboardSensor keyboardSensor1) {
        this.scores1 = scores;
        this.endKey1 = endKey;
        this.keyboardSensor = keyboardSensor1;
        this.stopped = false;
    }

    @Override
    public void doOneFrame(DrawSurface ds, double dt) {
        ds.setColor(Color.LIGHT_GRAY);
        ds.fillRectangle(0, 0, ds.getWidth(), ds.getHeight());
        ds.setColor(Color.BLACK);
        ds.drawText(51, 50, "High Scores", 32);
        ds.drawText(49, 50, "High Scores", 32);
        ds.drawText(50, 51, "High Scores", 32);
        ds.drawText(50, 49, "High Scores", 32);
        ds.setColor(Color.YELLOW);
        ds.drawText(50, 50, "High Scores", 32);
        ds.setColor(Color.BLACK);
        ds.drawText(101, 120, "Player Name", 24);
        ds.drawText(99, 120, "Player Name", 24);
        ds.drawText(100, 121, "Player Name", 24);
        ds.drawText(100, 119, "Player Name", 24);
        ds.setColor(Color.GREEN);
        ds.drawText(100, 120, "Player Name", 24);
        ds.setColor(Color.BLACK);
        ds.drawText(451, 120, "Score", 24);
        ds.drawText(449, 120, "Score", 24);
        ds.drawText(450, 121, "Score", 24);
        ds.drawText(450, 119, "Score", 24);
        ds.setColor(Color.GREEN);
        ds.drawText(450, 120, "Score", 24);
        ds.setColor(Color.BLACK);
        ds.drawLine(100, 130, 700, 130);
        ds.setColor(Color.GREEN);
        ds.drawLine(100, 131, 700, 131);
        ds.setColor(Color.BLACK);
        ds.drawLine(100, 132, 700, 132);
        ds.setColor(Color.BLACK);

        for (int i = 0; i < this.scores1.getHighScores().size(); ++i) {
            ScoreInfo scoreInfo = this.scores1.getHighScores().get(i);
            int nameX = 100;
            int scoreX = 450;
            int entryY = 170 + i * 40;
            ds.setColor(Color.BLACK);
            ds.drawText(nameX + 1, entryY, scoreInfo.getName(), 24);
            ds.drawText(nameX - 1, entryY, scoreInfo.getName(), 24);
            ds.drawText(nameX, entryY + 1, scoreInfo.getName(), 24);
            ds.drawText(nameX, entryY - 1, scoreInfo.getName(), 24);
            ds.setColor(Color.ORANGE);
            ds.drawText(nameX, entryY, scoreInfo.getName(), 24);
            ds.setColor(Color.BLACK);
            ds.drawText(scoreX + 1, entryY, "" + scoreInfo.getScore(), 24);
            ds.drawText(scoreX - 1, entryY, "" + scoreInfo.getScore(), 24);
            ds.drawText(scoreX, entryY + 1, "" + scoreInfo.getScore(), 24);
            ds.drawText(scoreX, entryY - 1, "" + scoreInfo.getScore(), 24);
            ds.setColor(Color.ORANGE);
            ds.drawText(scoreX, entryY, "" + scoreInfo.getScore(), 24);
        }

        String msg = "Press space to continue";
        ds.setColor(Color.BLACK);
        ds.drawText(199, 500, msg, 32);
        ds.setColor(Color.decode("#1788d0"));
        ds.drawText(200, 501, msg, 32);
        ds.setColor(Color.BLACK);
        ds.drawText(202, 502, msg, 32);
    }


    @Override
    public boolean shouldStop() {
        return false;
    }
}