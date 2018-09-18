package Question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayImplementationTest {
	ArrayImplementation<Integer> arrayStack;
	/*
	 * Initialize object of ArrayImplementation class.
	 */
	@Before
	public void initialize(){
		arrayStack=new ArrayImplementation<Integer>(5);
	}

	/*
	 * peekElementOfStackTest - test the functionality of class
	 */
	@Test
	public void peekElementOfStackTest() {
		arrayStack.push(10);
		Integer a=10;
		arrayStack.push(5);
		arrayStack.pop();
		assertEquals(arrayStack.peek(), a);
	}

}
