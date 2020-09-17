package construction;

import geometry.Block;
import geometry.ColorBackground;
import geometry.ImageBackground;
import geometry.Velocity;
import levels.GenericLevel;
import levels.LevelInformation;

import java.awt.Image;
import java.awt.Color;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Level specification reader.
 */
public class LevelSpecificationReader {

    private int height;
    private int width;
    private int startY;
    private int startX;
    private int rowHeight;

    private BlocksFromSymbolsFactory blocksFromSymbolsFactory;

    /**
     * From reader list.
     *
     * @param reader the reader
     * @return the list
     */
    public List<LevelInformation> fromReader(java.io.Reader reader) {
        List<LevelInformation> levelList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#") && line.startsWith("START_LEVEL")) {
                    levelList.add(createOneLevel(bufferedReader));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return levelList;
    }

    /**
     * LevelInformation function.
     *
     * @param bufferedReader the bufferedReader.
     * @return the LevelInformation data.
     * @throws IOException an exception
     */
    private LevelInformation createOneLevel(BufferedReader bufferedReader) throws IOException {
        boolean first = true;
        GenericLevel genericLevel = new GenericLevel();

        String line = bufferedReader.readLine();
        while (!line.equals("END_LEVEL")) {
            String property = line.split(":")[0];
            if (property.equals("START_BLOCKS")) {
                List<Block> blocks = readLevelLayout(bufferedReader);
                genericLevel.setBlocks(blocks);
                line = bufferedReader.readLine();
                continue;
            }
            String value = line.split(":")[1];

            if (property.equals("level_name")) {
                genericLevel.setLevelName(value);
            }
            if (property.equals("ball_velocities")) {
                List<Velocity> velocities = new ArrayList<>();
                String[] pairs = value.split(" ");
                for (String pair : pairs) {
                    int angle = Integer.parseInt(pair.split(",")[0]);
                    int speed = Integer.parseInt(pair.split(",")[1]);
                    velocities.add(Velocity.fromAngleAndSpeed(angle, speed));
                }
                genericLevel.setVelocities(velocities);
            }

            if (property.equals("background")) {
                if (value.contains("RGB")) {
                    String[] rGBValues = value.substring(10, value.length() - 2).split(",");
                    Color c = new Color(Integer.parseInt(rGBValues[0]), Integer.parseInt(rGBValues[1]),
                            Integer.parseInt(rGBValues[2]));
                    genericLevel.setBackgroundSprite(new ColorBackground(c, 0, 0, 600, 800));
                } else if (value.startsWith("color")) {
                    String colorName = value.substring(6, value.length() - 1);
                    Color c = Utils.colorFromString(colorName);
                    genericLevel.setBackgroundSprite(new ColorBackground(c, 0, 0, 600, 800));

                } else {
                    String imagePath = value.substring(6, value.length() - 1);
                    Image img = Utils.getImageFromPath(imagePath);
                    genericLevel.setBackgroundSprite(new ImageBackground(img));

                }
            }
            if (property.equals("paddle_speed")) {
                genericLevel.setPaddleSpeed(Integer.parseInt(value));
            }
            if (property.equals("paddle_width")) {
                genericLevel.setPaddleWidth(Integer.parseInt(value));
            }
            if (property.equals("block_definitions")) {
                InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(value);
//                FileReader fileReader = new FileReader(new File(value));
                BlocksDefinitionReader blocksDefinitionReader = new BlocksDefinitionReader();
                blocksFromSymbolsFactory = blocksDefinitionReader.
                        parseBlockDefinitionsFile(new BufferedReader(new InputStreamReader(is)));
            }
            if (property.equals("blocks_start_x")) {
                startX = Integer.parseInt(value);
            }
            if (property.equals("blocks_start_y")) {
                startY = Integer.parseInt(value);
            }
            if (property.equals("row_height")) {
                rowHeight = Integer.parseInt(value);
            }
            if (property.equals("num_blocks")) {
                genericLevel.setNumberOfBlocksToClear(Integer.parseInt(value));
            }
            line = bufferedReader.readLine();
        }

        return genericLevel;
    }

    /**
     * read Level Layout function.
     *
     * @param bufferedReader the bufferedReader
     * @return list of Block
     * @throws IOException exception
     */
    private List<Block> readLevelLayout(BufferedReader bufferedReader) throws IOException {
        List<Block> blocks = new ArrayList<>();
        String line = bufferedReader.readLine();

        int xForBlocks = startX;
        int yForBlocks = startY;
        while (!line.equals("END_BLOCKS")) {
            for (int i = 0; i < line.length(); i++) {
                String symbol = String.valueOf(line.charAt(i));
                if (blocksFromSymbolsFactory.isBlockSymbol(symbol)) {
                    Block b = blocksFromSymbolsFactory.getBlock(symbol, xForBlocks, yForBlocks);
                    blocks.add(b);
                    xForBlocks += b.getCollisionRectangle().getWidth();
                }
                if (blocksFromSymbolsFactory.isSpaceSymbol(symbol)) {
                    xForBlocks += blocksFromSymbolsFactory.getSpaceWidth(symbol);
                }
            }
            yForBlocks += rowHeight;
            xForBlocks = startX;
            line = bufferedReader.readLine();
        }
        return blocks;
    }


}




