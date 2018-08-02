/**
 * This interface is made for Shapes Properties
 */

package implementation;

public interface Shape {

    enum ShapeType {
        Square, Rectangle, Circle, Triangle;
    }

    double getArea();

    double getPerimeter();

    Point getOrigin();

    boolean isPointEnclosed(Point isPointEnclosed);

    long getTimestamp();

    ShapeType getShapeType();
}