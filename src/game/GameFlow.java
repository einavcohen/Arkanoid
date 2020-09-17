package game;

import animation.AnimationRunner;
import animation.HighScoresAnimation;
import animation.KeyPressStoppableAnimation;
import biuoop.DialogManager;
import levels.GameLevel;
import levels.LevelInformation;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * game flow class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class GameFlow {

    private DialogManager dialog;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter numberOfLives;
    private Counter score;
    private HighScoresTable highScoresTable;

    /**
     * Instantiates a new game flow.
     *
     * @param ar               the ar
     * @param ks               the ks
     * @param dialog1          the dialog 1
     * @param sizeOfHighScore  the size of high score
     * @param highScoresTable  highScoresTable table
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, DialogManager dialog1,
                    HighScoresTable highScoresTable, int sizeOfHighScore) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.dialog = dialog1;
        this.numberOfLives = new Counter(7);
        this.score = new Counter(0);
        this.highScoresTable = highScoresTable;
        if (this.highScoresTable == null) { // in case there is no file
            this.highScoresTable = new HighScoresTable(sizeOfHighScore);
        }

    }


    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean ifLost = false;
        this.numberOfLives.setCounter(7);
        this.score.setCounter(0);
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, numberOfLives, score);

            level.initialize();

            while (this.numberOfLives.getValue() > 0 && level.getRemainingBlocks().getValue() > 0) {
                level.playOneTurn();
            }

            // Loss
            if (this.numberOfLives.getValue() <= 0) {
                ifLost = true;
                break;
            }
        }

        EndGame endGame = new EndGame(this.keyboardSensor, score, true);
        KeyPressStoppableAnimation endGameKeyPress =
                new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, endGame);
        animationRunner.run(endGameKeyPress);

        if (this.highScoresTable.addScoreShouldBeAdded(score.getValue())) {
            String name = this.dialog.showQuestionDialog("Name", "What is your name?", "");
            ScoreInfo scoreInfo = new ScoreInfo(name, this.score.getValue());

            this.highScoresTable.add(scoreInfo);
            try {
                File file = new File("highscores.txt");
                this.highScoresTable.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        HighScoresAnimation highScoresAnimation =
                new HighScoresAnimation(this.highScoresTable, KeyboardSensor.SPACE_KEY, this.keyboardSensor);
        KeyPressStoppableAnimation highScoreKeyPress =
                new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, highScoresAnimation);
        this.animationRunner.run(highScoreKeyPress);

    }
}