package shapes;

import java.text.DecimalFormat;

import implementation.Point;
import implementation.Shape;
import implementation.ShapeType;

/*
 * Circle class - implements the property of shape interface
 */
public class Circle implements Shape {

	private final double radius;
	private final Point origin;
	private final long timestamp;
	private DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	/*
	 * Circle constructor - Intialize the value of radius, origin and timestamp
	 */
	public Circle(double radius, Point origin, long timestamp) {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
		Point originPoint = getOrigin();
		if (originPoint == null) {
			throw new NullPointerException("The Circle is out of Screen");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getArea()
	 * getArea - to evaluate the area of Circle
	 * @return Area of Circle
	 */
	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(Math.PI * radius * radius));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getPerimeter()
	 * getPerimeter - to evaluate the perimeter of Circle
	 * @return perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * Math.PI * radius));
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#getOrigin()
	 * getOrigin - find the origin of circle
	 * @return Point of origin
	 */
	@Override
	public Point getOrigin() {
		double valueOfX1, valueOfX2, valueOfY, A, B, C;
		double M = origin.getyPoint() / origin.getxPoint();
		A = (Math.pow(M, 2) + 1);
		B = (-2 * (M * origin.getyPoint() + origin.getxPoint()));
		C = (Math.pow(origin.getyPoint(), 2) + Math.pow(origin.getxPoint(), 2) - Math.pow(radius, 2));
		double underRoot = Math.sqrt((Math.pow(B, 2) - 4 * A * C));
		valueOfX1 = (-B + underRoot) / (2 * A);
		valueOfX2 = (-B - underRoot) / (2 * A);
		if (valueOfX1 <= origin.getxPoint()) {
			valueOfY = M * valueOfX1;
			return new Point(valueOfX1, valueOfY);
		} else if (valueOfX2 <= origin.getxPoint()) {
			valueOfY = M * valueOfX2;

			return new Point(valueOfX2, valueOfY);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see implementation.Shape#isPointEnclosed(implementation.Point)
	 * isPointEnclosed - check whether point is enclosed in circle or not
	 * @param Point - to be checked
	 * @return boolean value - true if exist or false
	 */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		boolean value = false;
		if (Math.pow(origin.getxPoint() - isPointEnclosed.getxPoint(), 2)
				+ Math.pow(origin.getyPoint() - isPointEnclosed.getyPoint(), 2) <= Math.pow(radius, 2)) {
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
		return ShapeType.Circle;
	}
}
