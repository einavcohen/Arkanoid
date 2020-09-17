//package levels;
//
//
//import geometry.Block;
//import geometry.Sprite;
//import geometry.Velocity;
//import biuoop.DrawSurface;
//
//import java.awt.Color;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Wide easy class.
// *
// * @author Einav Cohen
// * @version 24 April 2018
// */
//public class WideEasy implements LevelInformation {
//
//    /**
//     * Instantiates a new Wide easy.
//     */
//    public WideEasy() {
//    }
//
//    /**
//     * numberOfBalls func.
//     *
//     * @return number of balls.
//     */
//    public int numberOfBalls() {
//        return 10;
//    }
//
//    /**
//     * initialBallVelocities func.
//     *
//     * @return list of the velocitys of the balls.
//     */
//    public List<Velocity> initialBallVelocities() {
//        List<Velocity> velocities = new LinkedList();
//        double speed = 300;
//
//        velocities.add(Velocity.fromAngleAndSpeed(50, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(40, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(30, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(20, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(10, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-10, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-20, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-30, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-40, speed));
//        velocities.add(Velocity.fromAngleAndSpeed(-50, speed));
//        return velocities;
//    }
//
//    /**
//     * paddleSpeed.
//     *
//     * @return the speed of the paddle.
//     */
//    public int paddleSpeed() {
//        return 1;
//    }
//
//    /**
//     * paddleWidth.
//     *
//     * @return the width of the paddle.
//     */
//    public int paddleWidth() {
//        return 600;
//    }
//
//    /**
//     * levelName func.
//     *
//     * @return the name of the level.
//     */
//    public String levelName() {
//        return "Wide Easy";
//    }
//
//    /**
//     * Draw background.
//     *
//     * @param d the d
//     */
//    public void drawBackground(DrawSurface d) {
//        d.setColor(Color.WHITE);
//        d.fillRectangle(0, 25, d.getWidth(), d.getHeight());
//        d.setColor(Color.decode("#efe7b0"));
//        d.fillCircle(150, 150, 60);
//        int numRays = 100;
//        int startX = 25;
//        int endX = 775;
//
//        for (int i = 1; i <= numRays; ++i) {
//            d.drawLine(150, 150, (endX - startX) / numRays * i, 250);
//        }
//
//        d.setColor(Color.decode("#ecd749"));
//        d.fillCircle(150, 150, 50);
//        d.setColor(Color.decode("#ffe118"));
//        d.fillCircle(150, 150, 40);
//    }
//
//    /**
//     * blocks func.
//     *
//     * @return list of blocks.
//     */
//    public List<Block> blocks() {
//        List<Block> blocks = new LinkedList();
//        int y = 250;
//        int blockHeight = 25;
//        blocks.add(new Block(25, y, 50, blockHeight, 1, Color.RED, Color.BLACK));
//        blocks.add(new Block(75, y, 50, blockHeight, 1, Color.RED, Color.BLACK));
//        blocks.add(new Block(125, y, 50, blockHeight, 1, Color.ORANGE, Color.BLACK));
//        blocks.add(new Block(175, y, 50, blockHeight, 1, Color.ORANGE, Color.BLACK));
//        blocks.add(new Block(225, y, 50, blockHeight, 1, Color.YELLOW, Color.BLACK));
//        blocks.add(new Block(275, y, 50, blockHeight, 1, Color.YELLOW, Color.BLACK));
//        blocks.add(new Block(325, y, 50, blockHeight, 1, Color.GREEN, Color.BLACK));
//        blocks.add(new Block(375, y, 50, blockHeight, 1, Color.GREEN, Color.BLACK));
//        blocks.add(new Block(425, y, 50, blockHeight, 1, Color.GREEN, Color.BLACK));
//        blocks.add(new Block(475, y, 50, blockHeight, 1, Color.BLUE, Color.BLACK));
//        blocks.add(new Block(525, y, 50, blockHeight, 1, Color.BLUE, Color.BLACK));
//        blocks.add(new Block(575, y, 50, blockHeight, 1, Color.PINK, Color.BLACK));
//        blocks.add(new Block(625, y, 50, blockHeight, 1, Color.PINK, Color.BLACK));
//        blocks.add(new Block(675, y, 50, blockHeight, 1, Color.CYAN, Color.BLACK));
//        blocks.add(new Block(725, y, 50, blockHeight, 1, Color.CYAN, Color.BLACK));
//        return blocks;
//    }
//
//    /**
//     * numberOfBlocksToRemove func.
//     *
//     * @return the numbers of blocks to remove.
//     */
//    public int numberOfBlocksToRemove() {
//        return 15;
//    }
//
//    /**
//     * getBackground func.
//     *
//     * @return new object of sprite.
//     */
//    public Sprite getBackground() {
//        return new Sprite() {
//            @Override
//            public void drawOn(DrawSurface d) {
//                drawBackground(d);
//            }
//
//            @Override
//            public void timePassed( double dt) {
//                return;
//            }
//        };
//    }
//}
//
