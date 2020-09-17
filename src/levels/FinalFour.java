//package levels;
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
// * Final four class.
// *
// * @author Einav Cohen
// * @version 24 April 2018
// */
//
//public class FinalFour implements LevelInformation {
//    private List<Block> blocks = new LinkedList();
//
//    /**
//     * Instantiates a new Final four.
//     */
//    public FinalFour() {
//        Color[] colors = new Color[]{Color.GRAY, Color.RED,
//                Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
//        int[] hitPoints = new int[]{2, 1, 1, 1, 1, 1, 1};
//        int y = 100;
//        int blockWidth = 25;
//
//        for (int i = 0; i < colors.length; ++i) {
//            for (int j = 0; j < 15; ++j) {
//                this.blocks.add(new Block(j * 50 + 25, y, 50, blockWidth, hitPoints[i], colors[i]));
//            }
//
//            y += blockWidth;
//        }
//
//    }
//
//    /**
//     * @return the number of the balls.
//     */
//    public int numberOfBalls() {
//        return 3;
//    }
//
//    /**
//     * @return the list of a velocity of the balls.
//     */
//    public List<Velocity> initialBallVelocities() {
//        List<Velocity> velocities = new LinkedList();
//        double speed = 240;
//        velocities.add(Velocity.fromAngleAndSpeed(40.0D, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(0.0D, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-40.0D, speed));
//        return velocities;
//    }
//
//    /**
//     * @return the speed of the paddle.
//     */
//    public int paddleSpeed() {
//        return (int) 180;
//    }
//
//    /**
//     * @return the paddle width.
//     */
//    public int paddleWidth() {
//        return 85;
//    }
//
//    /**
//     * @return the level name.
//     */
//    public String levelName() {
//        return "Final Four";
//    }
//
//    /**
//     * Draw background.
//     *
//     * @param d the d
//     */
//    public void drawBackground(DrawSurface d) {
//        d.setColor(Color.decode("#1788d0"));
//        d.fillRectangle(0, 25, d.getWidth(), d.getHeight());
//        d.setColor(Color.WHITE);
//
//        int i;
//        for (i = 0; i < 10; ++i) {
//            d.drawLine(105 + i * 10, 400, 80 + i * 10, 600);
//        }
//
//        d.setColor(Color.decode("#cccccc"));
//        d.fillCircle(100, 400, 23);
//        d.fillCircle(120, 420, 27);
//        d.setColor(Color.decode("#bbbbbb"));
//        d.fillCircle(140, 390, 29);
//        d.setColor(Color.decode("#aaaaaa"));
//        d.fillCircle(160, 420, 22);
//        d.fillCircle(180, 400, 32);
//        d.setColor(Color.WHITE);
//
//        for (i = 0; i < 10; ++i) {
//            d.drawLine(605 + i * 10, 520, 580 + i * 10, 600);
//        }
//
//        d.setColor(Color.decode("#cccccc"));
//        d.fillCircle(600, 500, 23);
//        d.fillCircle(620, 540, 27);
//        d.setColor(Color.decode("#bbbbbb"));
//        d.fillCircle(640, 510, 29);
//        d.setColor(Color.decode("#aaaaaa"));
//        d.fillCircle(660, 530, 22);
//        d.fillCircle(680, 520, 32);
//    }
//
//    /**
//     * @return list of blocks.
//     */
//    public List<Block> blocks() {
//        return this.blocks;
//    }
//
//    /**
//     * @return the number of blocks that need to removed.
//     */
//    public int numberOfBlocksToRemove() {
//        return this.blocks.size();
//    }
//
//    /**
//     * @return sprite that draw the background.
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
