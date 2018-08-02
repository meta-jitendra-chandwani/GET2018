package implementation;


public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			System.out.println("Point out of Screen Size");
		}
	}

	boolean checkLocation() {
		boolean value=false;
		if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
			value = true;
		}
		return value;
	}

	public double getxPoint() {
		return xPoint;
	}

	public double getyPoint() {
		return yPoint;
	}
}
