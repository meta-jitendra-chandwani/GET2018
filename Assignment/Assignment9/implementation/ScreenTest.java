package implementation;



import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import implementation.ShapeType;

public class ScreenTest {

	/*
	 * testAddShape - function to add shape on screen
	 */
	@Test
	public void testAddShapes() {
		Screen.addShape(ShapeType.Circle, new Point(100, 200), new ArrayList<>(Arrays.asList(100d)));
		Screen.addShape(ShapeType.Circle, new Point(20, 3), new ArrayList<>(Arrays.asList(30d)));
		Screen.addShape(ShapeType.Rectangle, new Point(1, 23), new ArrayList<>(Arrays.asList(12d, 23d)));
		
	}

}
