package shapes;

import java.text.DecimalFormat;
import implementation.Point;
import implementation.Shape;

/**
 * This Rectangle class implements Shape interface
 */
public class Rectangle implements Shape {

	final double width;
	final double height;
	final Point origin;
	final long timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Rectangle(double width, double height, Point origin, long timestamp) {
		this.width = width;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		return Double
				.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier
				.format(2 * (width + height)));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		boolean value=false;
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width
				&& origin.getyPoint() <= isPointEnclosed.getyPoint()
				&& isPointEnclosed.getyPoint() <= origin.getyPoint() + height) {
			value = true;
		}

		return value;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Rectangle;
	}

}
