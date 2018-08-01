

public class Circle implements Shape {
	double radius;
	float xPoint,yPoint;
	
	public Circle(float xPoint,float yPoint,double radius) {
		this.xPoint=xPoint;
		this.yPoint=xPoint;
		this.radius=radius;
	}
	
	@Override
	public double getArea() {
		return 3.14*radius*radius;
	}

	@Override
	public double getPerimeter() {
		return 2*3.14*radius;
	}

	@Override
	public boolean isPointEnclosed() {
		return false;
	}

	@Override
	public Point getOrigin() {
		Point pointCircle = new Point(xPoint, yPoint);
		return pointCircle;
	}

}
