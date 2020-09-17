package geometry;

/**
 * Point class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Point {
    private double x;
    private double y;

    /**
     * constarctor of Point.
     *
     * @param x x point val.
     * @param y y point val.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double.
     *
     * @param other Point other.
     * @return a calculate of the distance between 2 points.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }


    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other other point
     * @return true if equals else false
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        } else {
            return other.getX() == this.x && other.getY() == this.y;
        }
    }

    /**
     * getter for x.
     *
     * @return x x
     */
    public double getX() {
        return this.x;
    }

    /**
     * getter for y.
     *
     * @return y y
     */
    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

