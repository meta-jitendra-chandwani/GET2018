import java.util.List;

public class ShapeFactory {

	static Object createShape(String shapeType, Point point,
			List<Integer> parameterOfShape) {
		Shape shape=null;
		if(shapeType.equals(_ShapeType_.RECTANGLE)){
			shape = new Rectangle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0),
					parameterOfShape.get(1));
		}
		else if(shapeType.equals(_ShapeType_.CIRCLE)){
			shape = new Circle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0));			
		}
		else if(shapeType.equals(_ShapeType_.SQUARE)){
			shape = new Square(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0));
		}
		else if(shapeType.equals(_ShapeType_.TRIANGLE)){
			shape = new Rectangle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0),
					parameterOfShape.get(1));
		}
//		switch (shapeType) {
//		case RECTANGLE:
//			shape = new Rectangle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0),
//					parameterOfShape.get(1));
//			break;
//		case CIRCLE:
//			shape = new Circle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0));
//			break;
//
//		case SQUARE:
//			shape = new Square(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0));
//			break;
//		case TRIANGLE:
//			shape = new Triangle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0), parameterOfShape.get(1), parameterOfShape.get(2));
//			break;
		
//		}

		if (shapeType.equals(_ShapeType_.RECTANGLE)) {
			new Rectangle(point.getxPoint(), point.getyPoint(), parameterOfShape.get(0),
					parameterOfShape.get(1));
		} else if (shapeType.equals(_ShapeType_.CIRCLE)) {

		} else if (shapeType.equals(_ShapeType_.SQUARE)) {

		} else if (shapeType.equals(_ShapeType_.TRIANGLE)) {

		}
		return shape;

	}
}
