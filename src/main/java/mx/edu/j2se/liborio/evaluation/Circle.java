package mx.edu.j2se.liborio.evaluation;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    /**
     * @param radius must be positive
     * @throws IllegalArgumentException
     */
    public Circle(double radius) throws IllegalArgumentException {
        if (radius <= 0) {
            throw new IllegalArgumentException("the radius was invalid");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * @param radius must be positive
     * @throws IllegalArgumentException
     */
    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius <= 0) {
            throw new IllegalArgumentException("the radius was invalid");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
