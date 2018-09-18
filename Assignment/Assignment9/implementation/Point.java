package implementation;

public class Point {
	private final double xPoint;
	private final double yPoint;

	/*
	 * Point constructor - initialize the xPoint and yPoint
	 */
	public Point(double xPoint, double yPoint) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			System.out.println("Point out of Screen Size");
		}
	}

	/*
	 * checkLocation - check location of xPoint and yPoint Is these are inside
	 * the Screen or not
	 */
	public boolean checkLocation() {
		boolean value = false;
		try {
			if (xPoint >= 0 && xPoint <= 1920 && yPoint >= 0 && yPoint <= 1080) {
				value = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;
	}

	/*
	 * getxPoint
	 * @return xPoint of object Point class
	 */
	public double getxPoint() {
		return xPoint;
	}

	/*
	 * getyPoint
	 * @return yPoint of object Point class
	 */
	public double getyPoint() {
		return yPoint;
	}
}