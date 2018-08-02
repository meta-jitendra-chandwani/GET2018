package shapes;

import java.text.DecimalFormat;

import implementation.Point;
import implementation.Shape;
import implementation.ShapeType;


/*
 * Rectangle class - implements the property of shape interface
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

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getArea()
	 * getArea - to evaluate the area of Rectangle
	 */
	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getPerimeter()
	 * getPerimeter - to evaluate the perimeter of Rectangle
	 * @return - parameter of rectangle
	 */
	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier
				.format(2 * (width + height)));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getOrigin()
	 * getOrigin - find the origin of rectangle
	 * @return Point of rectangle
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#isPointEnclosed(implementation.Point)
	 * isPointEnclosed - check whether point is enclosed in Rectangle or not
	 * @param Point - to be checked
	 * @return boolean value - true if exist or false
	 */
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
		return ShapeType.Rectangle;
	}

}
