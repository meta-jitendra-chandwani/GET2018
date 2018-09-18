package shapes;

import java.text.DecimalFormat;
import implementation.Point;
import implementation.Shape;
import implementation.ShapeType;

/*
 * Square class - implements the property of shape interface
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

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getArea()
	 * getArea - to evaluate the area of Rectangle
	 */
	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * width));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getPerimeter()
	 * getPerimeter - to evaluate the perimeter of Square
	 * @return - perimeter of square
	 */
	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * width));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getOrigin()
	 * getOrigin - find the origin of square
	 * @return Point of square
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#isPointEnclosed(implementation.Point)
	 * isPointEnclosed - check whether point is enclosed in square or not
	 * @param Point - to be checked
	 * @return boolean value - true if exist or false
	 */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		boolean value =false;
		if (origin.getxPoint() <= isPointEnclosed.getxPoint()
				&& isPointEnclosed.getxPoint() <= origin.getxPoint() + width) {
			if (origin.getyPoint() <= isPointEnclosed.getyPoint()
					&& isPointEnclosed.getyPoint() <= origin.getyPoint() + width) {
				value = true;
			}
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getTimestamp()
	 * getTimestamp - get the timestamp of circle when added to the screen
	 * @return - timestamp of circle
	 */
	@Override
	public long getTimestamp() {
		return timestamp;
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getShapeType()
	 * getShapeType - get type of shape
	 * @return the shape type from enum
	 */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
}
