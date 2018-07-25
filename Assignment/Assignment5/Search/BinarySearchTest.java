import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	Search search;
	private int array[];
	private int element;
	private int index;

	@Before
	public void initializeObject() {
		search = new Search();
	}

	public BinarySearchTest(int element, int array[], int index) {
		this.array = array;
		this.element = element;
		this.index = index;
	}

	@Parameters
	public static Collection<Object[]> maxMirror() {
		int search[] = { 2, 3, 4, 10, 40 };
		int search1[] = { 4, 8, 41, 96, 100 };
		return Arrays.asList(new Object[][] { { 3, search, 1 },
				{ 41, search1, 2 } });
	}

	@Test
	public void binarySearchTest() {
		assertEquals(search.binarySearch(element, array, 0, array.length - 1),
				index);
	}

}
