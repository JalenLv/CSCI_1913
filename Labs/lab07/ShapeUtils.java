// Name: Qiming Lyu

public class ShapeUtils {
    /**
     * This function takes two points and computes the distance between them.
     * 
     * @param p1 the first point
     * @param p2 the second point
     */
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p1.getX() - p2.getX(), 2)
                        + Math.pow(p1.getY() - p2.getY(), 2));
    }

    /**
     * This function takes an array of points and computes the center of the points.
     * 
     * @param points the array of points
     */
    public static Point getCenter(Point[] points) {
        double x = 0;
        double y = 0;
        for (Point point : points) {
            x += point.getX();
            y += point.getY();
        }

        Point center;
        if (points.length == 0) {
            center = new Point(0, 0);
        } else {
            center = new Point(x / points.length, y / points.length);
        }
        return center;
    }

    /**
     * This function takes a circle and computes the area of the circle.
     * 
     * @param c the circle
     */
    public static double getArea(Circle c) {
        return Math.PI * Math.pow(c.getRadius(), 2);
    }

    /**
     * This function takes a ring and computes the area of the ring.
     *
     * @param c the ring
     */
    public static double getArea(Ring c) {
        double r2 = c.getInnerCircle().getRadius();
        double r1 = r2 + c.getThickness();
        return Math.PI * (Math.pow(r1, 2) - Math.pow(r2, 2));
    }

    /**
     * This function takes a circle and a point and determines if the point is in
     * the circle.
     * This is done by checking if the distance between the center of the circle and
     * the point is less than or equal to the radius of the circle.
     * 
     * @param c the circle
     * @param p the point
     */
    public static boolean isIn(Circle c, Point p) {
        return distance(c.getCenter(), p) <= c.getRadius();
    }
}
