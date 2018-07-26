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
public class DegreePolynomialTest {

	Poly poly1;
	private double coeff1[];
	private int Result;

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
	 * @param Result - Degree of polynomial
	 */
	public DegreePolynomialTest(double coeff1[], int Result) {
		this.coeff1 = coeff1;
		this.Result = Result;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> degreeMethodTestCases() {
		double coeffArray1[] = { 3, 1, 2, 4 };
		int Result = 3;

		return Arrays.asList(new Object[][] { { coeffArray1, Result } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void degreeMethodTest() {
		assertEquals(poly1.degree(), Result);
	}
}