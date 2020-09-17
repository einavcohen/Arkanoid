package geometry;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private static final int NUM_OF_LINES = 4;


    /**
     * constructor.
     *
     * @param upperLeft upperLeft point val
     * @param width     width of the rect
     * @param height    height of the rect
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * create a linesArray of the  4 lines of a rect and init them.
     *
     * @return Lines array.
     */
    public Line[] linesArray() {
        Line leftLineRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() - height);

        Line rightLineRectangle = new Line(this.upperLeft.getX() + width, this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY() - height);

        Line topLineRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY());

        Line bottomLineRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY() - height,
                this.upperLeft.getX() + width, this.upperLeft.getY() - height);

        Line[] linesOfRectangle = new Line[NUM_OF_LINES];

        linesOfRectangle[0] = leftLineRectangle;
        linesOfRectangle[1] = rightLineRectangle;
        linesOfRectangle[2] = topLineRectangle;
        linesOfRectangle[3] = bottomLineRectangle;

        return linesOfRectangle;
    }

    /**
     * getter for the left line of the rect.
     *
     * @return Line. left line rect
     */
    public Line getLeftLineRect() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + height);
    }

    /**
     * getter for the right line of the rect.
     *
     * @return Line. right line rectangle
     */
    public Line getRightLineRectangle() {
        return new Line(this.upperLeft.getX() + width, this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
    }

    /**
     * getter for the top line of the rect.
     *
     * @return Line. top line rectangle
     */
    public Line getTopLineRectangle() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY());
    }

    /**
     * getter for the bottom line of the rect.
     *
     * @return Line. bottom line rectangle
     */
    public Line getBottomLineRectangle() {
        return new Line(this.upperLeft.getX(), this.upperLeft.getY() + height,
                this.upperLeft.getX() + width, this.upperLeft.getY() + height);
    }

    /**
     * check if there  is an intersection between a line and the 4 lines of a rect.
     * enter the inter point to an list.
     *
     * @param line line.
     * @return list of intersection Points.
     */
    public List intersectionPoints(Line line) {
        ArrayList<Point> pointsList = new ArrayList<>();
// Return a (possibly empty) List of intersection points.
        // with the specified line.

        if (this.getTopLineRectangle().intersectionWith(line) != null) {
            pointsList.add(this.getTopLineRectangle().intersectionWith(line));
        }
        if (this.getRightLineRectangle().intersectionWith(line) != null) {
            pointsList.add(this.getRightLineRectangle().intersectionWith(line));
        }
        if (this.getLeftLineRect().intersectionWith(line) != null) {
            pointsList.add(this.getLeftLineRect().intersectionWith(line));
        }
        if (this.getBottomLineRectangle().intersectionWith(line) != null) {
            pointsList.add(this.getBottomLineRectangle().intersectionWith(line));
        }
        return pointsList;
    }

    /**
     * getter for the Width of a rect.
     *
     * @return width. width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getter for the height of a rect.
     *
     * @return height. height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getter for the upperLeft of a rect.
     *
     * @return upperLeft. upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * setter for the upperLeft point of a rect.
     *
     * @param upperLeftp upperLeft.
     */
    public void setUpperLeft(Point upperLeftp) {
        this.upperLeft = upperLeftp;
    }

    /**
     * draw a rect on the surface.
     *
     * @param d     surface
     * @param color color of a rect
     */
    public void drawOn(DrawSurface d, Color color) {
        d.setColor(color);
        int x1 = (int) this.getUpperLeft().getX();
        int y1 = (int) this.getUpperLeft().getY();
        int height1 = (int) this.getHeight();
        int width1 = (int) this.getWidth();
        d.fillRectangle(x1, y1, width1, height1);
    }

}

