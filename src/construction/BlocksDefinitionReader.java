package construction;

import geometry.Background;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Blocks definition reader.
 */
public class BlocksDefinitionReader {
    private GenericBlock defaultBlock;

    /**
     * Parse block definitions file blocks from symbols factory.
     *
     * @param reader the reader
     * @return the blocks from symbols factory
     * @throws IOException the io exception
     */
    public BlocksFromSymbolsFactory parseBlockDefinitionsFile(BufferedReader reader) throws IOException {
        boolean first = true;

        Map<String, Integer> spacerWidths = new HashMap<>();
        Map<String, GenericBlock> blockCreators = new HashMap<>();

        String line = reader.readLine();

        while (line != null) {
            if (!first) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
            }
            first = false;
            if (line.startsWith("#") || line.equals("")) {
                continue;
            }

            List<String> values = Arrays.asList(line.split(" "));
            String property = values.get(0);
            switch (property) {
                case "default":
                    this.defaultBlock = parseProperties(values, 1);
                    break;
                case "bdef":
                    String symbol = values.get(1).split(":")[1];
                    GenericBlock bc = parseProperties(values, 2);
                    blockCreators.put(symbol, bc);
                    break;
                case "sdef":
                    if (values.size() != 3) {
                        continue;
                    }
                    String symbol1 = values.get(1).split(":")[1];
                    Integer width = null;
                    try {
                        width = Integer.parseInt(values.get(2).split(":")[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    spacerWidths.put(symbol1, width);
                    break;

                default:
                    System.out.println("Unexpected flow");
            }
        }

        return new BlocksFromSymbolsFactory(spacerWidths, blockCreators);
    }

    /**
     * @param properties the first part of the data.
     * @param startIndex the first index of the data.
     * @return GenericBlock.
     */
    private GenericBlock parseProperties(List<String> properties, int startIndex) {
        GenericBlock genericBlock;
        if (this.defaultBlock == null) {
            genericBlock = new GenericBlock();
        } else {
            genericBlock = this.defaultBlock.copy();
        }

        for (int i = startIndex; i < properties.size(); i++) {
            String[] splitedPair = properties.get(i).split(":");
            String key = splitedPair[0];
            String value = splitedPair[1];

            if (key.equals("height")) {
                genericBlock.setHeight(Integer.parseInt(value));
                continue;
            }
            if (key.equals("width")) {
                genericBlock.setWidth(Integer.parseInt(value));
                continue;
            }
            if (key.equals("hit_points")) {
                genericBlock.setHitPoints(Integer.parseInt(value));
                continue;
            }
            if (key.startsWith("fill")) {
                int hitPoints = -1;
                if (key.startsWith("fill-")) {
                    hitPoints = Integer.parseInt(key.split("-")[1]);
                }
                if (value.contains("RGB")) {
                    String[] rGBValues = value.substring(10, value.length() - 2).split(",");
                    Color c = new Color(Integer.parseInt(rGBValues[0]), Integer.parseInt(rGBValues[1]),
                            Integer.parseInt(rGBValues[2]));
                    Background background = new Background(c);
                    genericBlock.getHitsToBackground().put(hitPoints, background);
                } else if (value.contains("color")) {
                    String colorName = value.substring(6, value.length() - 1);
                    Color c = Utils.colorFromString(colorName);
                    Background background = new Background(c);
                    genericBlock.getHitsToBackground().put(hitPoints, background);
                } else {
                    String imagePath = value.substring(6, value.length() - 1);
                    Image img = Utils.getImageFromPath(imagePath);
                    Background background = new Background(img);
                    genericBlock.getHitsToBackground().put(hitPoints, background);
                }
                continue;
            }
            if (key.equals("stroke")) {
                Color c = null;
                if (value.contains("RGB")) {
                    String[] rGBValues = value.substring(10, value.length() - 2).split(",");
                    c = new Color(Integer.parseInt(rGBValues[0]), Integer.parseInt(rGBValues[1]),
                            Integer.parseInt(rGBValues[2]));
                } else if (value.contains("color")) {
                    String colorName = value.substring(6, value.length() - 1);
                    c = Utils.colorFromString(colorName);
                }
                genericBlock.setStroke(c);
            }
        }
        return genericBlock;
    }
}
