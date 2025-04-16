
public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Point) {
            Point point = (Point) p;
            return point.x == x && point.y == y;
        }
        return false;
    }
}
