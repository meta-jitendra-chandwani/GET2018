/*
 * area class is to compute area of different shapes
 */
public class Area {
    /*
     * compute the area of triangle
     * @param base of triangle
     * @param height of triangle
     * @return area of triangle
     */
    double Triangle(double base, double height) throws ArithmeticException {
        return 0.5 * base * height;
    }

    /*
     * compute the area of rectangle
     * @param length of rectangle
     * @param breadth of rectangle
     * @return area of rectangle
     */
    double Rectangle(double length, double breadth) throws ArithmeticException {
        return length * breadth;
    }

    /*
     * compute the area of square
     * @param length of square
     * @return area of square
     */
    double Square(double length) throws ArithmeticException {
        return length * length;
    }

    /*
     * compute the area of circle
     * @param radius of circle
     * @return area of circle
     */
    double Circle(double radius) throws ArithmeticException {
        return 3.14 * radius * radius;
    }
}