package implementation;


import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import implementation.ShapeType;

import java.util.Calendar;
import java.util.List;


/*
 * FactoryShape - It's a factory class for shape class which return object of shape class. 
 */
public class FactoryShape {
	static Shape createShape(ShapeType shapeType, Point origin, List<Double> parameters) {
	    Shape shape = null;
		if (shapeType == null || origin == null || parameters == null) {
			System.out.println("Provide all 3 parameters");
			return null;
		}
		
		switch (shapeType) {
		case Circle:
			if (parameters.size() != 1) {
				return null;
			}
			shape = new Circle(parameters.get(0), origin, Calendar.getInstance().getTimeInMillis());
		case Rectangle:
			if (parameters.size() != 2) { 
                return null;
			}
			shape = new Rectangle(parameters.get(0), parameters.get(1), origin, Calendar.getInstance().getTimeInMillis());
		case Square:
			if (parameters.size() != 1) {
                return null;
			}
			shape = new Square(parameters.get(0), origin, Calendar.getInstance().getTimeInMillis());
		case Triangle:
			if (parameters.size() != 1) {
                return null;
			}
			shape = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), origin, Calendar.getInstance().getTimeInMillis());
			
		}
		return shape;
	}
}