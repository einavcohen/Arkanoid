//package levels;
//
//
//
//import biuoop.DrawSurface;
//import geometry.Block;
//import geometry.Sprite;
//import geometry.Velocity;
//
//import java.awt.Color;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Green 3 class.
// *
// * @author Einav Cohen
// * @version 24 April 2018
// */
//public class Green3 implements LevelInformation {
//    private List<Block> blocks = new LinkedList();
//
//    /**
//     * Instantiates a new Green 3.
//     */
//    public Green3() {
//        Color[] colors = new Color[]{Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
//        int[] hitPoints = new int[]{2, 1, 1, 1, 1};
//        int y = 150;
//        int blockWidth = 25;
//
//        for (int i = 0; i < colors.length; ++i) {
//            for (int j = i + 5; j < 15; ++j) {
//                this.blocks.add(new Block(j * 50 + 25, y, 50, blockWidth, hitPoints[i], colors[i]));
//            }
//
//            y += blockWidth;
//        }
//
//    }
//
//    /**
//     * @return the number of balls.
//     */
//    public int numberOfBalls() {
//        return 2;
//    }
//
//    /**
//     * @return the list of velocity of the balls.
//     */
//    public List<Velocity> initialBallVelocities() {
//        List<Velocity> velocities = new LinkedList();
//        double speed = 5;
//        velocities.add(Velocity.fromAngleAndSpeed(40.0D, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-40.0D, speed));
//        return velocities;
//    }
//
//    /**
//     * @return the speed of the paddle.
//     */
//    public int paddleSpeed() {
//        return 360;
//    }
//
//    /**
//     * @return the width of the paddle.
//     */
//    public int paddleWidth() {
//        return 85;
//    }
//
//    /**
//     * @return the name of the level.
//     */
//    public String levelName() {
//        return "Green 3";
//    }
//
//    /**
//     * Draw background.
//     *
//     * @param d the d
//     */
//    public void drawBackground(DrawSurface d) {
//        d.setColor(Color.decode("#2a8215"));
//        d.fillRectangle(0, 25, d.getWidth(), d.getHeight());
//        d.setColor(Color.decode("#4e4a49"));
//        d.fillRectangle(110, 200, 10, 200);
//        d.setColor(Color.decode("#d8ac66"));
//        d.fillCircle(115, 200, 12);
//        d.setColor(Color.decode("#f64d36"));
//        d.fillCircle(115, 200, 8);
//        d.setColor(Color.WHITE);
//        d.fillCircle(115, 200, 3);
//        d.setColor(Color.decode("#3e3a39"));
//        d.fillRectangle(100, 400, 30, 200);
//        d.setColor(Color.decode("#2e2a29"));
//        d.fillRectangle(65, 450, 100, 200);
//        int startX = 75;
//        int startY = 460;
//        d.setColor(Color.WHITE);
//
//        for (int rows = 0; rows < 5; ++rows) {
//            for (int columns = 0; columns < 5; ++columns) {
//                d.fillRectangle(startX + columns * 18, startY + rows * 32, 10, 25);
//            }
//        }
//
//    }
//
//    /**
//     * @return the list of blocks.
//     */
//    public List<Block> blocks() {
//        return this.blocks;
//    }
//
//    /**
//     * @return the number of blocks that need to remove.
//     */
//    public int numberOfBlocksToRemove() {
//        return this.blocks.size();
//    }
//
//    /**
//     * @return the sprite object of the background.
//     */
//    public Sprite getBackground() {
//        return new Sprite() {
//            @Override
//            public void drawOn(DrawSurface d) {
//                drawBackground(d);
//            }
//
//            @Override
//            public void timePassed(double dt) {
//                return;
//            }
//        };
//    }
//}
//
