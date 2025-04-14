/**
 * Point class file.
 * CSCI 1913.
 * Written by Min Namgung and Daniel Kluver
 * Provided.
 *
 * A point is represented by two double values x, and y.
 */
public class Point {
    // private -- so you can't touch it outside of this file.
    private double x, y;

    /**
     * @param x the x-coordinate of the point.
     * @param y the y-coordinate of the point.
     *
     * Computers historically represent coordinate grids so that top-left is (0,0)
     * down is positive-y (so moving down would lead to larger values of y)
     * right is positive-x (so moving right would lead to larger values of x)
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate of this point
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y coordinate of this point
     */
    public double getY() {
        return y;
    }

    /**
     * Move the point
     * @param dx amount to move x by
     * @param dy amount to move y by
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * rotate the point about the origin of the coordinate system (0,0)
     *
     * @param theta an angle given in degrees
     */
    public void rotateAroundOrigin(double theta) {
        theta = Math.toRadians(theta);
        double x_new = x * Math.cos(theta) - y * Math.sin(theta);
        y = y * Math.cos(theta) + x * Math.sin(theta);
        x = x_new;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
