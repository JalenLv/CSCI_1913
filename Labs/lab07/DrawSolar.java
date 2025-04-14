// Name: Qiming Lyu

import java.awt.Color;
import java.util.Random;

public class DrawSolar {
    public static void main(String[] args) {
        // Create a new canvas of 640x640 pixels.
        final int WIDTH = 640;
        ShapeDrawer canvas = new ShapeDrawer(WIDTH, WIDTH);

        // Draw random stars that uniformly spread across the canvas
        Random r = new Random();
        final int seed = 2025;
        r.setSeed(seed);
        final int NUM_STARS = 750;
        canvas.setStroke(Color.WHITE);
        for (int i = 0; i < NUM_STARS; i++) {
            int x = r.nextInt(WIDTH);
            int y = r.nextInt(WIDTH);
            canvas.draw(new Point(x, y));
        }

        // Draw the sun at the center of the canvas.
        final int radiusSun = 50;
        Circle sun = new Circle(
                new Point(WIDTH / 2, WIDTH / 2),
                radiusSun);
        canvas.setFill(Color.YELLOW);
        canvas.setStroke(Color.YELLOW);
        canvas.draw(sun);

        // Draw the orbit of the earth
        Ring orbitEarth = new Ring(
                new Circle(
                        sun.getCenter(),
                        WIDTH / 4),
                1);
        canvas.setFill(Color.WHITE);
        canvas.draw(orbitEarth);

        // Draw the earth
        Point centerEarth = new Point(orbitEarth.getInnerCircle().getRadius(), 0);
        centerEarth.rotateAroundOrigin(-120);
        centerEarth.move(sun.getCenter().getX(), sun.getCenter().getY());

        final int radiusEarth = 15;
        Circle earth = new Circle(centerEarth, radiusEarth);

        Color BLUE = new Color(84, 188, 249);
        canvas.setStroke(BLUE);
        canvas.setFill(BLUE);
        canvas.draw(earth);

        // Draw the orbit of the moon
        Ring orbitMoon = new Ring(
                new Circle(
                        earth.getCenter(),
                        WIDTH / 12),
                1);
        canvas.setFill(Color.WHITE);
        canvas.draw(orbitMoon);

        // Draw the moon
        Point centerMoon = new Point(orbitMoon.getInnerCircle().getRadius(), 0);
        centerMoon.rotateAroundOrigin(30);
        centerMoon.move(earth.getCenter().getX(), earth.getCenter().getY());

        final int radiusMoon = 10;
        Circle moon = new Circle(centerMoon, radiusMoon);

        canvas.setStroke(Color.WHITE);
        canvas.setFill(Color.WHITE);
        canvas.draw(moon);

        canvas.writeToFile("solar.png");
    }
}
