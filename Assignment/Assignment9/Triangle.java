
public class Triangle implements Shape {
	float xPoint, yPoint, side1, side2, side3;

	public Triangle(float xPoint, float yPoint, float side1, float side2,
			float side3) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public double getArea() {
		float s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}

	@Override
	public double getPerimeter() {
		return (side1+side2+side3);
	}

	@Override
	public boolean isPointEnclosed() {

		return false;
	}

	@Override
	public Point getOrigin() {
		Point pointTriangle = new Point(xPoint, yPoint);
		return pointTriangle;
	}

}
