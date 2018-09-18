package Assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfixToPostFixTest {
	private InfixToPostFix infixToPostFix;
	
	/*
	 * Initialize object of InfixToPostFix class.
	 */
	@Before
	public void initialize(){
		infixToPostFix=new InfixToPostFix(10);
	}

	/*
	 * infixToPostfixTest - test the functionality of class
	 */
	@Test
	public void infixToPostfixTest() {
		String expression = "A && H <= A";
		String result = "AHA<=&&";
		assertEquals(infixToPostFix.infixToPostfix(expression), result);
	}

}
