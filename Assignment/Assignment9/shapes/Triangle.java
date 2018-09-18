package shapes;

import java.text.DecimalFormat;
import implementation.ShapeType;
import implementation.Point;
import implementation.Shape;

/*
 * Triangle class - implements the property of shape interface
 */
public class Triangle implements Shape {
    private Point origin;
    private Point pointA;
    private Point pointB;
    private double height;
    private double base;
    private double sideA;
    private double sideB;
    private double slopeA;
    private double slopeB;
    DecimalFormat df = new DecimalFormat("####0.00");
    long timeStamp;

    public Triangle(double height, double base, double sideA, Point origin, long timestamp) {
        this.height = height;
        this.base = base;
        this.sideA = sideA;
        computeOtherParameters();
        this.origin = origin;
        this.timeStamp = timestamp;
    }
    
    /*
	 * (non-Javadoc)
	 * @see implementation.Shape#getArea()
	 * getArea - to evaluate the area of Triangle
	 */
    @Override
    public double getArea() {
        double perimeter = getPerimeter() / 2;
        return Double.parseDouble(df.format(Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - base))));
    }

    /*
	 * (non-Javadoc)
	 * @see implementation.Shape#getPerimeter()
	 * getPerimeter - to evaluate the perimeter of Triangle
	 * @return - perimeter of triangle
	 */
    @Override
    public double getPerimeter() {
        return Double.parseDouble(df.format(sideA + sideB + base));
    }

    /*
	 * (non-Javadoc)
	 * @see implementation.Shape#getOrigin()
	 * getOrigin - find the origin of triangle
	 * @return Point of triangle
	 */
    public Point getOrigin() {
        return origin;
    }

    /*
	 * (non-Javadoc)
	 * @see implementation.Shape#isPointEnclosed(implementation.Point)
	 * isPointEnclosed - check whether point is enclosed in triangle or not
	 * @param Point - to be checked
	 * @return boolean value - true if exist or false
	 */
    public boolean isPointEnclosed(Point isPointEnclosed) {
    	boolean value = false;
        if (isPointEnclosed.getyPoint() - slopeA * isPointEnclosed.getxPoint() <= origin.getyPoint()
                - slopeA * origin.getyPoint()
                && isPointEnclosed.getyPoint() - slopeB * isPointEnclosed.getxPoint() <= pointA.getyPoint()
                        - slopeB * pointA.getxPoint()
                && isPointEnclosed.getyPoint() >= origin.getyPoint()) {
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
        return timeStamp;
    }
    
    /*
	 * (non-Javadoc)
	 * @see implementation.Shape#getShapeType()
	 * getShapeType - get type of shape
	 * @return the shape type from enum
	 */
    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    private void computeOtherParameters() {
        double difference = Math.sqrt(Math.pow(sideA, 2) - Math.pow(height, 2));
        double otherDifference = base - difference;
        sideB = Math.sqrt(Math.pow(height, 2) + Math.pow(otherDifference, 2));
        pointA = new Point(origin.getxPoint() + difference, origin.getyPoint() + height);
        pointB = new Point(origin.getxPoint() + base, origin.getyPoint());
        slopeA = (pointA.getyPoint() - origin.getyPoint()) / (pointA.getxPoint() - origin.getxPoint());
        slopeB = (pointA.getyPoint() - pointB.getyPoint()) / (pointA.getxPoint() - pointB.getxPoint());
    }
}
