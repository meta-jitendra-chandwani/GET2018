import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinearSearchTest {
	Search search;
	private int array[];
	private int element;
	private int index;

	/*
	 * Initialize the object
	 */
	@Before
	public void initializeObject() {
		search = new Search();
	}

	/*
	 * Parameterized Constructor - initialize the variable
	 * @param element - element to be search
	 * @param array - array
	 * @param index - element index in particular array
	 */
	public LinearSearchTest(int element, int array[], int index) {
		this.array = array;
		this.element = element;
		this.index = index;
	}

	/*
	 * Collection of Object -  contained the parameterized test case
	 * @return Collection Object
	 */
	@Parameters
	public static Collection<Object[]> maxMirror() {
		int search[] = { 2, 3, 4, 10, 40 };
		int search1[] = { 5, 6, 15, 4, 7, 78 };
		return Arrays.asList(new Object[][] { { 3, search, 1 },
				{ 7, search1, 4 } });
	}

	/*
	 * Test Case evaluation
	 * Check whether actual value is same as expected value
	 */
	@Test
	public void linearSearchTest() {
		assertEquals(search.linearSearch(element, array, array.length), index);
	}

}