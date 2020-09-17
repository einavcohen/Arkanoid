//package levels;
//
//import biuoop.DrawSurface;
//import geometry.Block;
//import geometry.Sprite;
//import geometry.Velocity;
//
//import java.awt.Color;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Direct hit class.
// *
// * @author Einav Cohen
// * @version 24 April 2018
// */
//public class DirectHit implements LevelInformation {
//
//    private double frameDt = 60;
//    private double dt = 1 / frameDt;
//    /**
//     * @return the num of balls in list.
//     */
//    public int numberOfBalls() {
//        return 1;
//    }
//
//    /**
//     * @return the velocitys list of the balls.
//     */
//    public List<Velocity> initialBallVelocities() {
//        return Arrays.asList(Velocity.fromAngleAndSpeed(
//                0.0, 240));
//    }
//
//    /**
//     * @return int the speed of a paddle.
//     */
//    public int paddleSpeed() {
//        return 480;
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
//        return "Direct Hit";
//    }
//
//    /**
//     * Draw background.
//     *
//     * @param d the d
//     */
//    public void drawBackground(DrawSurface d) {
//        d.setColor(Color.BLACK);
//        d.fillRectangle(0, 25, d.getWidth(), d.getHeight());
//        d.setColor(Color.BLUE);
//        d.drawCircle(400, 162, 60);
//        d.drawCircle(400, 162, 90);
//        d.drawCircle(400, 162, 120);
//        d.drawLine(400, 182, 400, 302);
//        d.drawLine(420, 162, 540, 162);
//        d.drawLine(380, 162, 260, 162);
//        d.drawLine(400, 142, 400, 22);
//    }
//
//    /**
//     * @return the blocks list.
//     */
//    public List<Block> blocks() {
//        return Arrays.asList(new Block(385, 150, 30, 30, 1, Color.RED));
//    }
//
//    /**
//     * @return the number of blocks to remove from game.
//     */
//    public int numberOfBlocksToRemove() {
//        return 1;
//    }
//
//    /**
//     * Returns a sprite with the background of the level.
//     *
//     * @return the sprite obg of the background.
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
