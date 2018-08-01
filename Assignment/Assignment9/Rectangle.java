
public class Rectangle implements Shape {
	float xPoint, yPoint, length, breadth;

	public Rectangle(float xPoint, float yPoint, float length, float breadth) {
		this.xPoint=xPoint;
		this.yPoint=yPoint;
		this.length=length;
		this.breadth=breadth;
	}

	@Override
	public double getArea() {
		return length*breadth;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+breadth);
	}

	@Override
	public boolean isPointEnclosed() {
		return false;
	}

	@Override
	public Point getOrigin() {
		Point pointRectangle = new Point(xPoint, yPoint);
		return pointRectangle;
	}

}
