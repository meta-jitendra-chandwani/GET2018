package Polynomial;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EvatuatePolynomialTest {
	Poly poly1;
	private double coeff1[];
	private float value;
	private float Result;

	/*
	 * Initialize the object
	 */
	@Before
	public void initializeObject() {
		poly1 = new Poly(coeff1);
	}

	/*
	 * Parameterized Constructor - initialize the variable
	 * @param coeff1 - coefficient 1 array
	 * @param value - value of variable
	 * @param result - evaluation result
	 */
	public EvatuatePolynomialTest(double coeff1[], float value,	float Result) {
		this.coeff1 = coeff1;
		this.Result = Result;
		this.value = value;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> evaluateMethodTestCases() {
		double coeffArray1[] = { 3, 1, 2, 4 };
		float value = 4;
		float addResult = 220;

		return Arrays.asList(new Object[][] { { coeffArray1, value,
				addResult } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void evaluateMethodTest() {
		assertEquals(poly1.evaluate(value), Result, 0);
	}
}