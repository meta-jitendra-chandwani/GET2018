package implementation;

import java.util.ArrayList;
import java.util.List;

import implementation.ShapeType;

/*
 * Screen class - which hold the shapes
 */
public class Screen {
	static ArrayList<Shape> shapesList = new ArrayList<>();
	
	/*
	 * addShape to add shape on screen
	 * @param shapeType -  enum of shape
	 * @param point - Object of Point class - consist origin point of shape
	 * @param parameter - parameter of shape such as Rectangle has 2 parameter length and breadth
	 */
	static void addShape(ShapeType shapeType, Point point, List<Double> parameters) {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
	}

	/*
	 * deleteShape to delete shape from the screen
	 * @param shapeType -  enum of shape
	 * @param point - Object of Point class - consist origin point of shape
	 * @param parameter - parameter of shape such as Rectangle has 2 parameter length and breadth
	 */
	static boolean deleteShape(ShapeType shapeType, Point point, List<Double> parameters) {
		boolean value = false;
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType && shapesList.get(i).getOrigin() == point) {
				shapesList.remove(i);
				value= true;
			}
		}
		return value;
	}

	/*
	 * deleteShapesOfSpecificType to delete the shape of specific type from the screen
	 * @param shapeType -  enum of shape
	 */
	static void deleteShapesOfSpecificType(ShapeType shapeType) {
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getShapeType() == shapeType) {
				shapesList.remove(i);
				break;
			}
		}
	}

	/*
	 * ascendingInArea -  sort the shape list according to their respective area.
	 */
	static ArrayList<Shape> ascendingInArea() {
		ArrayList<Shape> sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1).getArea()) {
					Shape swap = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, swap);
				}
			}
		}
		return sortedShapes;
	}

	/*
	 * ascendingInPerimeter -  sort the shape list according to their respective perimeter.
	 */
	static ArrayList<Shape> ascendingInPerimeter() {
		ArrayList<Shape> sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes.get(j + 1).getPerimeter()) {
					Shape swap = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, swap);
				}
			}
		}
		return sortedShapes;
	}

	/*
	 * ascendingInTimestamp -  sort the shape list according to their respective time stamp.
	 */
	static ArrayList<Shape> ascendingInTimestamp() {
		ArrayList<Shape> sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimestamp() > (sortedShapes.get(j + 1).getTimestamp())) {
					Shape swap = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, swap);
				}
			}
		}
		return sortedShapes;
	}

	/*
	 * ascendingInOriginDistance -  sort the shape list according to their respective origin distance.
	 */
	static ArrayList<Shape> ascendingInOriginDistance() {
		ArrayList<Shape> sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getyPoint(), 2));
				double originDistanceJ1 = Math.sqrt(Math.pow(sortedShapes.get(j + 1).getOrigin().getxPoint(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin().getyPoint(), 2));
				if (originDistanceJ > originDistanceJ1) {
					Shape swap = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, swap);
				}
			}
		}
		return sortedShapes;
	}

	/*
	 * isPointEnclosed - check whether point is enclosed in shape or not
	 * @param Point - to be checked
	 * @return List of shape which enclosed the point 
	 */
	static ArrayList<Shape> isPointEnclosed(Point point) {
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}
		return pointEnclosedShapes;
	}
}