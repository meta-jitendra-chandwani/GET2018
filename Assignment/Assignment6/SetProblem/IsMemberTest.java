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
public class IsMemberTest {
	intSet set;
	private int array[];
	private int element;
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
	 * @param element - to be search in universal set
	 * @param result - test result
	 */
	public IsMemberTest(int array[], int element, boolean result) {
		this.array = array;
		this.element = element;
		this.result = result;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> isMemberTestCases() {
		int setArray1[] = { 1, 2, 2, 3, 4, 4 };
		int setArray2[] = { 5, 2, 4, 89, 65 };
		int setArray3[] = { 5, 1, 8, 3, 9, 4, 5, 2 };

		return Arrays.asList(new Object[][] { { setArray1, 2, true },
				{ setArray2, 56, false }, { setArray3, 1, true } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void isMemberTest() {
		assertEquals(set.isMember(element, array), result);
	}
}