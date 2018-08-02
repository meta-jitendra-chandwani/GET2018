package shapes;

import java.text.DecimalFormat;
import implementation.Point;
import implementation.Shape;
/**
 * This Square class implements Shape interface
 */
public class Square implements Shape {

	final double width;
	final Point origin;
	final long timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Square(double width, Point origin, long timestamp) {
		this.width = width;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * width));
	}

	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * width));
	}

	public Point getOrigin() {
		return origin;
	}

	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width) {
			if (origin.getyPoint() <= isPointEnclosed.getyPoint()
					&& isPointEnclosed.getyPoint() <= origin.getyPoint() + width) {
				return true;
			}
		}
		return false;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
}
