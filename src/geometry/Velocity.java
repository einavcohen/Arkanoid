package geometry;


/**
 * Velocity class.
 *
 * @author Einav Cohen
 * @version 24 April 2018
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constractor.
     *
     * @param dx2 dx val point
     * @param dy2 dy val point
     */
    public Velocity(double dx2, double dy2) {
        this.dx = dx2;
        this.dy = dy2;
    }

    /**
     * getter for x.
     *
     * @return x dx
     */
    public double getDX() {
        return this.dx;
    }

    /**
     * getter for y.
     *
     * @return y. dy
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * Set dx.
     *
     * @param dx2 new value for dx.
     */
    public void setDx(double dx2) {
        this.dx = dx;
    }


    /**
     * Sets dy.
     *
     * @param dy2 dy2.
     */
    public void setDy(double dy2) {
        this.dy = dy;
    }

    /**
     * set Velocity of the ball.
     *
     * @param angle dx val
     * @param speed dy val
     * @return Velocity velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * apply the set the new center.
     *
     * @param p point p.
     * @return new point.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Scale by dt velocity.
     *
     * @param dt the dt
     * @return the velocity
     */
    public Velocity scaleByDt(double dt) {
        return new Velocity(this.dx * dt, this.dy * dt);
    }
}
