package mx.edu.j2se.liborio.evaluation;

public class Evaluation1 {
    public static void main(String[] args) {
        try {
            Circle circle = new Circle(-2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Circle[] circles = {
                new Circle(3),
                new Circle(9),
                new Circle(7)
        };

        int idxLargestCircle = biggestCircle(circles);
        System.out.println("the radius of the largest circle is " +circles[idxLargestCircle].getRadius());
    }

    public static int biggestCircle(Circle[] circles) {

        double largestCircle = circles[0].getArea();
        int idxLargestCircle = 0;
        for (int i = 0; i < circles.length; i++) {
            if (circles[i].getArea() > largestCircle) {
                largestCircle=circles[i].getArea();
                idxLargestCircle = i;
            }
        }
        return idxLargestCircle;
    }
}
