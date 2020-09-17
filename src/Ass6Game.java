package main;
import animation.HighScoresAnimation;
import animation.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import construction.LevelSet;
import game.HighScoresTable;
import animation.AnimationRunner;
import game.GameFlow;
import menu.Menu;
import menu.MenuAnimation;
import menu.RunLevelsTask;
import menu.Task;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
/**
 * The Ass5Game class.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */
public class Ass6Game {

    /**
     * void main is the main method that starts the program and call the other methods.
     *
     * @param args array of string used to pass params to the main method.
     * @throws IOException io exception.
     */
    public static void main(String[] args) throws IOException {
        GUI gui = new GUI("Arkanoid", 800, 600);
        File file = new File("highscores.txt");
        HighScoresTable highScoresTable = HighScoresTable.loadFromFile(file);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        GameFlow game = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui.getDialogManager(),
                highScoresTable, 10);


        Menu<Task<Void>> mainMenu = new MenuAnimation<>("Main Menu!",
                gui.getKeyboardSensor(), animationRunner);
        Menu<Task<Void>> levelSetsMenu = new MenuAnimation<>("Level Sets Menu",
                gui.getKeyboardSensor(), animationRunner);

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("level_sets.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(is));
        List<LevelSet> levelSets = new ArrayList<>();
        String line;
        LevelSet ls = new LevelSet();
        while ((line = lineNumberReader.readLine()) != null) {
            if (lineNumberReader.getLineNumber() % 2 != 0) {
                ls.setKey(line.split(":")[0]);
                ls.setName(line.split(":")[1]);
            } else {
                ls.setPath(line);
                levelSets.add(ls);
                ls = new LevelSet();
            }
        }

        for (LevelSet levelset : levelSets) {
            levelSetsMenu.addSelection(levelset.getKey(), levelset.getName(),
                    new RunLevelsTask(game, levelset.getPath()));
        }


        mainMenu.addSubMenu("s", "Start the game!", levelSetsMenu);

        mainMenu.addSelection("h", "High Scores!", new Task<Void>() {
            @Override
            public Void run() {
                try {
                    HighScoresTable highScoresTable = HighScoresTable.loadFromFile(file);
                    HighScoresAnimation highScoresAnimation = new HighScoresAnimation(highScoresTable,
                            KeyboardSensor.SPACE_KEY
                            , gui.getKeyboardSensor());
                    KeyPressStoppableAnimation keyPressStoppableAnimation =
                            new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                            KeyboardSensor.SPACE_KEY, highScoresAnimation);
                    animationRunner.run(keyPressStoppableAnimation);
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        mainMenu.addSelection("q", "Quit the game!", new Task<Void>() {
            @Override
            public Void run() {
                System.exit(0);
                return null;
            }
        });


        while (true) {
            animationRunner.run(mainMenu);
            Task<Void> returnVal = mainMenu.getStatus();
            returnVal.run();
            mainMenu.reset();
        }

    }

//    /**
//     * checks what levels the user requested.
//     *
//     * @param args arguments
//     * @return list of levels
//     */
//    private static List<LevelInformation> chosenLevels(String[] args) {
//
//        List<LevelInformation> levels = new ArrayList<LevelInformation>();
//        //no args
//        if (args == null || args.length == 0) {
//            List<LevelInformation> arr = new ArrayList<LevelInformation>(ALL_LEVELS_LIST);
//            //don't add the first nul obj
//            return arr;
//        }
//        for (String level : args) {
//            try {
//                int curLevel = Integer.parseInt(level);
//                if (curLevel > ALL_LEVELS_LIST.size() - 1 || curLevel == 0) {
//                    continue;
//                }
//                levels.add(ALL_LEVELS_LIST.get(curLevel));
//            } catch (Exception e) {
//                continue;
//            }
//        }
//        return levels;
//    }

}





/*

public class Ass6Game {

    public static void main(String[] args){
        game.HighScoresTable table=new game.HighScoresTable(5);

        table.add(new game.ScoreInfo("d",4));
        table.add(new game.ScoreInfo("h",8));
        table.add(new game.ScoreInfo("a",1));
        table.add(new game.ScoreInfo("g",7));
        table.add(new game.ScoreInfo("b",2));
        table.add(new game.ScoreInfo("c",3));
        table.add(new game.ScoreInfo("f",6));
        table.add(new game.ScoreInfo("e",5));






        File file=new File("highscores");
        try{
            table.save("highscores");
        }catch (Exception e){
            e.printStackTrace();
        }
        table.clear();
        game.HighScoresTable t;
        try {
            table.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        table.add(new game.ScoreInfo("i",9));





        File file1=new File("highscores");
        try{
            table.save("highscores");
        }catch (Exception e){
            e.printStackTrace();
        }
        table.clear();
        game.HighScoresTable t;
        try {
            table.load(file1);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < table.scores.size(); i++) {
            System.out.print(table.scores.get(i).getName());
            System.out.println(table.scores.get(i).getScore());
        }


    }
*/






   /*
    public static void main(String[] args) {

        File file = new File("highscores");
        HighScoresTable table = new HighScoresTable(4);
        ScoreInfo one = new ScoreInfo("omry", 120);
        ScoreInfo two = new ScoreInfo("wazzzup", 130);
        ScoreInfo three = new ScoreInfo("so close!", 125);
        table.add(two);
        table.add(one);
        table.add(three);
        System.out.println("before save tablr: ");
        table.printTable();
        try {
            table.save(new File("table.ser"));

        } catch (IOException e) {
             TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            table.load(new File("table.ser"));
        } catch (IOException e) {
             TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("after load table: ");
        table.printTable();
        ScoreInfo four = new ScoreInfo("so close 2", 125);
        ScoreInfo five = new ScoreInfo("shame", 50);
        table.add(four);
        table.add(five);
        System.out.println("before save tablr: ");
        table.printTable();
        try {
            table.save(new File("table.ser"));
        } catch (IOException e) {
             TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            table.load(new File("table.ser"));
        } catch (IOException e) {
             TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("after load table: ");
        table.printTable();


        GUI gui = new GUI("T", 800, 600);
        HighScoresAnimation h = new HighScoresAnimation(table, KeyboardSensor.SPACE_KEY, gui.getKeyboardSensor());
        AnimationRunner a = new AnimationRunner(gui, 60);
        a.run(h);
        gui.close();


        }
    }
*/