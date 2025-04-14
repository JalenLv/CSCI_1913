/**
 * Circle class file.
 * CSCI 1913.
 * Written by Min Namgung and Daniel Kluver
 * Provided, with changes expected
 * Changes made by: Qiming Lyu
 *
 * A circle is represented by a Point object (the center) and a radius.
 */

public class Circle {
    private Point center;
    private double radius;

    /**
     * @param center -- a non-null point indicating the location of the center of
     *               the circle.
     * @param radius -- the radius of the circle.
     */
    public Circle(Point center, double radius) {
        if (radius < 0) {
            radius = 0;
        }
        this.center = center;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double getArea(Circle c) {
        return Math.PI * Math.pow(c.radius, 2);
    }

    /**
     * Get radius
     **/
    public double getRadius() {
        return radius;
    }

    /**
     * @return a non-null point indicating the center of this circle.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Update the center of this circle
     * 
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Set a new radius of the circle.
     * 
     * @param r the new radius. must me greater than zero.
     */
    public void setRadius(int r) {
        if (r < 0) {
            System.out.println("ERROR negative radius passed to setRadius. Setting radius to 0");
            radius = 0;
        } else {
            this.radius = r;
        }
    }

    /**
     * Move original (x, y) center point to new (x+dx, y+dy) point
     */
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    /**
     * Generate a string-representation of the circle.
     * This will be used automatically by java in a few places.
     * Most notably -- the string this returns is what will be shown if you print a
     * circle object.
     * 
     * @return a string that represents the circle.
     */
    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    /**
     * Check if one circle is equal to another circle.
     * <i> TECHNICALLY </i> this checks if a circle is equal to any other object
     * although you will probably only need to use it to check if one circle is
     * equal to another circle.
     * It might not be obvious from the way the function is written -- but you can
     * pass this method a Circle.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Circle circle = (Circle) o;
        return circle.radius == radius && center.equals(circle.center);
    }
}
