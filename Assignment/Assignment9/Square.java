
public class Square implements Shape {
	float xPoint, yPoint, side;

	public Square(float xPoint, float yPoint, float side) {
		this.side = side;
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public boolean isPointEnclosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getOrigin() {
		Point pointSquare = new Point(xPoint, yPoint);
		return pointSquare;
	}

}
