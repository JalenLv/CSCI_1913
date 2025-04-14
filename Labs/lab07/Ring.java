/**
 * Ring class.
 * CSCI 1913.
 * Written by Peter Wang and Daniel Kluver
 * Provided.
 *
 * A ring is represented by a circle, which defines the inner part of the shape, and a thinkcness.
 */


public class Ring {
    private Circle innerCircle;
    private double thickness;

    /**
     * Create a new Ring, takes a Circle to serve as the inner circles, and a double to serve as the thickness.
     * If a negative thickness is passed a default thickness will be used.
     * If a null circle is passed something will probably crash.
     */
    public Ring(Circle innerCircle, double thickness) {
        if (thickness < 0) {
            thickness = 0.1;
        }
        this.innerCircle = innerCircle;
        this.thickness = thickness;

    }


    public double getThickness() {
        return thickness;
    }

    public Circle getInnerCircle() {
        return innerCircle;
    }

    @Override
    public String toString() {
        return "Ring{" +
                "innerCircle=" + innerCircle +
                ", thickness=" + thickness +
                '}';
    }
}
