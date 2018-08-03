package Assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PostfixEvaluationTest {
	private PostfixEvaluation postfixEvaluation;
	
	/*
	 * Initialize object of PostfixEvaluation class.
	 */
	@Before
	public void initialize(){
		postfixEvaluation=new PostfixEvaluation(10);
	}

	/*
	 * postfixEvaluationTest - test the functionality of class
	 */
	@Test
	public void postfixEvaluationTest() {
		String expression = "2 6 * 5 +";
		int result = 17;
		assertEquals(postfixEvaluation.evaluateExpression(expression), result);
	}

}
