package SetProblem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IsSubsetTest {
	intSet set;
	private int array[];
	private int subset[];
	private boolean result;

	/*
	 * Initialize the object
	 */
	@Before
	public void initializeObject() {
		set = new intSet();
	}
	
	/*
	 * Parameterized Constructor - initialize the variable
	 * @param array - universal array
	 * @param subset - subset array
	 * @param result - subset test result
	 */
	public IsSubsetTest(int array[], int subset[], boolean result) {
		this.array = array;
		this.subset = subset;
		this.result = result;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> isSubSetTestCases() {
		int setArray1[] = { 1, 2, 3, 4, 8, 9, 6 };
		int subsetArray1[] = { 6, 9, 2, -1 };
		int setArray2[] = { 1, 2, 3, 4, 8, 9, 6 };
		int subsetArray2[] = { 6, 9, 2, };
		return Arrays.asList(new Object[][] {
				{ setArray1, subsetArray1, false },
				{ setArray2, subsetArray2, true } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void isSubSetTest() {
		assertEquals(set.isSubset(subset, array), result);
	}
}