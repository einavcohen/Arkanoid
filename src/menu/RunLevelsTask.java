package menu;

import construction.LevelSpecificationReader;
import game.GameFlow;
import levels.LevelInformation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * The type Run levels task.
 */
public class RunLevelsTask implements Task<Void> {
    private GameFlow gameFlow;
    private String name;

    /**
     * Instantiates a new Run levels task.
     *
     * @param gameFlow the game flow
     * @param name     the name
     */
    public RunLevelsTask(GameFlow gameFlow, String name) {
        this.gameFlow = gameFlow;
        this.name = name;
    }

    @Override
    public Void run() {
        LevelSpecificationReader l = new LevelSpecificationReader();
        List<LevelInformation> levels = null;

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(name);
        levels = l.fromReader(new InputStreamReader(inputStream));
        gameFlow.runLevels(levels);
        return null;
    }
}
