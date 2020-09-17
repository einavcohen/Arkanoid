package game;

import java.io.File;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type High scores table.
 */
public class HighScoresTable implements Serializable {

    private int tableSize;
    private List<ScoreInfo> scoreInfoList;
    private static final long serialVersionUID = 1L;

    // Create an empty high-scores table with the specified size.
    // The size means that the table holds up to size top scores.

    /**
     * Instantiates a new High scores table.
     *
     * @param size the size
     */
    public HighScoresTable(int size) {
        this.tableSize = size;
        scoreInfoList = new ArrayList<>(size);
    }

    /**
     * Add.
     *
     * @param score the score
     */
// Add a high-score.
    public void add(ScoreInfo score) {
        if (this.addScoreShouldBeAdded(score.getScore())) {
            scoreInfoList.add(score);
            scoreInfoList.sort(new Comparator<ScoreInfo>() {
                @Override
                public int compare(ScoreInfo o1, ScoreInfo o2) {
                    if (o1.getScore() > o2.getScore()) {
                        return -1;
                    }
                    if (o1.getScore() < o2.getScore()) {
                        return 1;
                    }
                    return 0;
                }
            });
            // TODO remove un wanted scores
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
// Return table size.
    public int size() {
        return this.tableSize;
    }

    /**
     * Gets high scores.
     *
     * @return the high scores
     */
// Return the current high scores.
    // The list is sorted such that the highest
    // scores come first.
    public List<ScoreInfo> getHighScores() {
        return scoreInfoList;
    }

    /**
     * Gets rank.
     *
     * @param score the score
     * @return the rank
     */
// return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.
    public int getRank(int score) {
        //first score
        if (this.scoreInfoList.isEmpty()) {
            return 1;
        }

        //find rank of next score
        for (int i = 0; i < this.scoreInfoList.size(); i++) {
            if (score > this.scoreInfoList.get(i).getScore()) {
                return i + 1; //i+1 means the index+1 meaning the actual place in array
            }
        }
        return this.scoreInfoList.size() + 1;

//        if (scoreInfoList.indexOf(score) + 1 <= this.tableSize) {
//            return scoreInfoList.indexOf(score) + 1;
//        }
//        return -1;
//        //TODO : make sure the lowest scores get the rank -1, which means they wont show up in the high scores table.
    }

    /**
     * Add score should be added boolean.
     *
     * @param score the score
     * @return the boolean
     */
    public boolean addScoreShouldBeAdded(int score) {
        return (this.getRank(score) <= this.tableSize);
    }

    /**
     * Clear.
     */
// Clears the table
    public void clear() {
        //this.tableSize = 0;
        //this.scoreInfoList = null;
        scoreInfoList.clear();
    }

    /**
     * Load.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Load table data from file.
    // Current table data is cleared.
    public void load(File filename) throws IOException {
        HighScoresTable scoresTable = loadFromFile(filename);
        this.tableSize = scoresTable.size();
        this.scoreInfoList = scoresTable.getHighScores();
    }


    /**
     * Save.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Save table data to the specified file.
    public void save(File filename) throws IOException {
        ObjectOutputStream os = null;

        try {
            os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
        }
//
//        FileOutputStream fos = new FileOutputStream(filename);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        try {
//            oos.writeObject(this);
//        } finally {
//            if (oos != null) {
//                oos.close();
//            }
//        }
    }

    /**
     * Load from file high scores table.
     *
     * @param filename the filename
     * @return the high scores table
     * @throws IOException the io exception
     */
// Read a table from file and return it.
    // If the file does not exist, or there is a problem with
    // reading it, an empty table is returned.
    public static HighScoresTable loadFromFile(File filename) throws IOException {

        HighScoresTable currentTable = new HighScoresTable(5);
        if (!filename.exists()) {
            return currentTable;
        }
        ObjectInputStream os = null;

        try {
            os = new ObjectInputStream(new FileInputStream(filename));
            currentTable = (HighScoresTable) os.readObject();
            return currentTable;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
        }
        return null;
    }

    /**
     * Print table.
     */
    public void printTable() {
        int size = Math.min(this.tableSize, this.scoreInfoList.size());
        for (int i = 0; i < size; i++) {
            ScoreInfo scoreInfo = this.scoreInfoList.get(i);
            System.out.println("name:" + scoreInfo.getName() + "," + "score:" + scoreInfo.getScore());
        }
    }
}