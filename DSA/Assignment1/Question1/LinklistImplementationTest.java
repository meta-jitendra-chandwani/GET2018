package Question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinklistImplementationTest {
	private LinklistImplementation<Integer> linklistStack;
	
	/*
	 * Initialize object of LinklistImplementation class.
	 */
	@Before
	public void initialize(){
		linklistStack=new 	LinklistImplementation<Integer>();
	}

	/*
	 * peekElementOfStackTest - test the functionality of class
	 */
	@Test
	public void peekElementOfStackTest() {
		linklistStack.push(10);
		Integer a=10;
		linklistStack.push(5);
		linklistStack.pop();
		assertEquals(linklistStack.peek(), a);
	}
}
