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
public class MultiplicationPolynomialTest {
	Poly poly1, poly2;
	private double coeff1[];
	private double coeff2[];
	private double addResult[];

	/*
	 * Initialize the object
	 */
	@Before
	public void initializeObject() {
		poly1 = new Poly(coeff1);
		poly2 = new Poly(coeff2);
	}

	/*
	 * Parameterized Constructor - initialize the variable
	 * @param coeff1 - coefficient 1 array
	 * @param coeff2 - coefficient 2 array
	 * @param addRsult - Multiplication array
	 */
	public MultiplicationPolynomialTest(double coeff1[], double coeff2[], double addResult[]) {
		this.coeff1 = coeff1;
		this.coeff2 = coeff2;
		this.addResult = addResult;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> multiplicationMethodTestCases() {
		double coeffArray1[] = { 3, 1, 2, 4 };
		double coeffArray2[] = { 3, 1, 2, 4 };
		double addResult[] = { 9, 6, 13, 28, 12, 16, 16 };

		return Arrays.asList(new Object[][] { { coeffArray1, coeffArray2,
				addResult } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void multiplicationMethodTest() {
		assertArrayEquals(poly1.multiplicationPoly(poly1, poly2), addResult, 0);
	}
}