package geometry;

import java.util.List;

/**
 * line class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Line {
    private Point start;
    private Point end;
    private static double epsilon = 1.0E-4D;
    private double aX;
    private double bY;
    private double c;


    // constructors

    /**
     * first constructor of line.
     *
     * @param start start point
     * @param end   end point
     */
    public Line(Point start, Point end) {
        if (start.getX() < end.getX()) {
            this.start = new Point(start.getX(), start.getY());
            this.end = new Point(end.getX(), end.getY());
        } else {
            this.end = new Point(start.getX(), start.getY());
            this.start = new Point(end.getX(), end.getY());
        }
        this.aX = this.end.getY() - this.start.getY();
        this.bY = this.start.getX() - this.end.getX();
        this.c = this.aX * this.start.getX() + this.bY * this.start.getY();
    }

    /**
     * second constructor of line.
     *
     * @param x1 x1 val
     * @param y1 y1 val
     * @param x2 x2 val
     * @param y2 y2 val
     */
    public Line(double x1, double y1, double x2, double y2) {
        if (x1 < x2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.end = new Point(x1, y1);
            this.start = new Point(x2, y2);
        }
        this.aX = this.end.getY() - this.start.getY();
        this.bY = this.start.getX() - this.end.getX();
        this.c = this.aX * this.start.getX() + this.bY * this.start.getY();
    }

    /**
     * Length double.
     *
     * @return Return the length of the line.
     */
    public double length() {
        double pointx1 = this.start.getX();
        double pointx2 = this.end.getX();
        double pointy1 = this.start.getY();
        double pointy2 = this.end.getY();
        return Math.sqrt(Math.pow(pointx2 - pointx1, 2.0D) + Math.pow(pointy2 - pointy1, 2.0D));
    }

    /**
     * Middle point.
     *
     * @return Returns the middle point of the line.
     */
    public Point middle() {
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double midx = (x1 + x2) / 2.0D;
        double midy = (y1 + y2) / 2.0D;
        Point midpoint = new Point(midx, midy);
        return midpoint;
    }

    /**
     * Start point.
     *
     * @return Returns the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return Returns the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other other line.
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * checks if the doubles are equal.
     *
     * @param a the a value
     * @param b the b vlaue
     * @return true if equal else false
     */
    private boolean doubleEqual(double a, double b) {
        return Math.abs(a - b) <= epsilon;
    }

    /**
     * calculate the slope.
     *
     * @return slope
     */
    private double getSlope() {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        return this.doubleEqual(x1, x2) ? 1.0D / 0.0 : (this.start.getY() - this.end.getY()) / (x1 - x2);
    }

    /**
     * getter for aX.
     *
     * @return aX. x
     */
    public double getaX() {
        return aX;
    }

    /**
     * getter for bY.
     *
     * @return bY. y
     */
    public double getbY() {
        return bY;
    }

    /**
     * getter for c.
     *
     * @return c. c
     */
    public double getC() {
        return c;
    }

    /**
     * returns true if the given point is in the line segment.
     *
     * @param p the point
     * @return true if is in line else false
     */
    public boolean isInLine(Point p) {
        double diff = this.start.distance(p) + this.end.distance(p) - this.start.distance(this.end);
        if ((int) diff == 0) {
            return true;
        }
        return false;
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect rectangle
     * @return point point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        List<Point> interPointsList = rect.intersectionPoints(this);

        if (interPointsList.isEmpty()) {
            return null;
        }

        if (interPointsList.size() == 1) {
            return interPointsList.get(0);
        }
        Point minPoint = interPointsList.get(0);

        for (int j = 1; j < interPointsList.size(); j++) {
            if (interPointsList.get(j).distance(this.start) < minPoint.distance(this.start)) {
                minPoint = interPointsList.get(j);
            }
        }
        return minPoint;
    }

    /**
     * Returns the intersection point if the lines intersect,and null otherwise.
     *
     * @param other other line
     * @return inter point
     */
    public Point intersectionWith(Line other) {
        double det = (this.aX * other.getbY()) - (other.getaX() * this.bY);
        if (det == 0) {
            return null;
        } else {
            double newX = (other.getbY() * this.c - this.bY * other.getC()) / det;
            double newY = (this.aX * other.getC() - other.getaX() * this.c) / det;
            Point interPoint = new Point(newX, newY);
            if (this.isInLine(interPoint) && other.isInLine(interPoint)) {
                return interPoint;
            } else {
                return null;
            }
        }
    }

}






