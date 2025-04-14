import java.awt.image.CropImageFilter;
import java.util.Arrays;

public class ShapeUtilsTester {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Point distance test");
        // Point function tests:
        System.out.println("Test 1");
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(1.0, 0.0);
        double d1 = ShapeUtils.distance(p1, p2);
        System.out.println(d1); // 1.0

        System.out.println("Test 2");
        Point p3 = new Point(23.6, -34.5);
        double d2 = ShapeUtils.distance(p1, p3);
        System.out.println(d2); // 42.083369636948035

        Point[] points;
        Point p;
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Center point test");

        System.out.println("Test 1");
        points = new Point[3];
        points[0] = new Point(80, 0);
        points[1] = new Point(0, 10);
        points[2] = new Point(160, 10);

        p = ShapeUtils.getCenter(points);
        System.out.println(p); // (80.0, 6.666666666666667)

        System.out.println("Test 2");
        points = new Point[3];
        points[0] = new Point(12, 10);
        points[1] = new Point(0, 53);
        points[2] = new Point(30, 54);

        p = ShapeUtils.getCenter(points);
        System.out.println(p); // (14.0, 39.0)

        System.out.println("Test 3");
        points = new Point[3];
        points[0] = new Point(1, 0);
        points[1] = new Point(3, 4);
        points[2] = new Point(5, 4);

        p = ShapeUtils.getCenter(points);
        System.out.println(p); // (3.0, 2.6666666666666665)

        System.out.println("Test 4");
        points = new Point[0];
        // empty array: return (0, 0)
        p = ShapeUtils.getCenter(points);
        System.out.println(p); // (0.0, 0.0)

        System.out.println("Test 5");
        points = new Point[10];
        points[0] = new Point(1, 10);
        points[1] = new Point(2, 9);
        points[2] = new Point(3, 8);
        points[3] = new Point(4, 7);
        points[4] = new Point(5, 6);
        points[5] = new Point(6, 5);
        points[6] = new Point(7, 4);
        points[7] = new Point(8, 3);
        points[8] = new Point(9, 2);
        points[9] = new Point(10, 1);

        p = ShapeUtils.getCenter(points);
        System.out.println(p); // (5.5, 5.5)

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("get circle area Test");

        System.out.println("Test 1");
        Circle c = new Circle(new Point(1.0, 1.0), 2);
        double area = ShapeUtils.getArea(c);
        System.out.println(area); // 12.566370614359172
        area = Circle.getArea(c);
        System.out.println(area); // 12.566370614359172
        area = c.getArea();
        System.out.println(area); // 12.566370614359172

        System.out.println("Test 2");
        c = new Circle(new Point(3.1, 1.9), 0);
        area = ShapeUtils.getArea(c);
        System.out.println(area); // 0.0
        area = Circle.getArea(c);
        System.out.println(area); // 0.0
        area = c.getArea();
        System.out.println(area); // 0.0

        System.out.println("Test 3");
        c = new Circle(new Point(2.5, 1.0), -3);
        area = ShapeUtils.getArea(c);
        System.out.println(area); // 0.0
        area = Circle.getArea(c);
        System.out.println(area); // 0.0
        area = c.getArea();
        System.out.println(area); // 0.0

        System.out.println("Test 4");
        c = new Circle(new Point(8.0, 10.0), 10);
        area = ShapeUtils.getArea(c);
        System.out.println(area); // 314.1592653589793
        area = Circle.getArea(c);
        System.out.println(area); // 314.1592653589793
        area = c.getArea();
        System.out.println(area); // 314.1592653589793

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("get ring area Test");

        System.out.println("Test 1");
        double ring_area_test_1 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), 1));
        System.out.println(ring_area_test_1); // 15.707963267948966

        System.out.println("Test 2");
        double ring_area_test_2 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), -2));
        System.out.println(ring_area_test_2); // 1.2880529879718157

        System.out.println("Test 3");
        double ring_area_test_3 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), 10));
        System.out.println(ring_area_test_3); // 439.822971502571

        System.out.println("Test 4");
        double ring_area_test_4 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), -10));
        System.out.println(ring_area_test_4); // 1.2880529879718157

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Is in circle tests");

        System.out.println("Test 1");
        Circle c1 = new Circle(new Point(0, -5), 10);
        p = new Point(0, 0);
        System.out.println(ShapeUtils.isIn(c1, p)); // true

        System.out.println("Test 2");
        c1 = new Circle(new Point(0, -5), 1);
        p = new Point(0, 0);
        System.out.println(ShapeUtils.isIn(c1, p)); // false

        System.out.println("Test 3");
        c1 = new Circle(new Point(0, -5), 5);
        p = new Point(0, 0);
        System.out.println(ShapeUtils.isIn(c1, p)); // true

    }
}

/*
 * 
 * Point distance test
 * Test 1
 * 1.0
 * Test 2
 * 42.083369636948035
 * Center point test
 * Test 1
 * (80.0, 6.666666666666667)
 * Test 2
 * (14.0, 39.0)
 * Test 3
 * (3.0, 2.6666666666666665)
 * Test 4
 * (0.0, 0.0)
 * Test 5
 * (5.5, 5.5)
 * get circle area Test
 * Test 1
 * 12.566370614359172
 * 12.566370614359172
 * 12.566370614359172
 * Test 2
 * 0.0
 * 0.0
 * 0.0
 * Test 3
 * 0.0
 * 0.0
 * 0.0
 * Test 4
 * 314.1592653589793
 * 314.1592653589793
 * 314.1592653589793
 * get ring area Test
 * Test 1
 * 15.707963267948966
 * Test 2
 * 1.2880529879718157
 * Test 3
 * 439.822971502571
 * Test 4
 * 1.2880529879718157
 * Is in circle tests
 * Test 1
 * true
 * Test 2
 * false
 * Test 3
 * true
 * 
 */
