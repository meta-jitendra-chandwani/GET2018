import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest {
	Search search = new Search();

	@Test
	public void test() {
		int array[] = { 2, 3, 4, 10, 40 };
		int length = array.length - 1;
		int actual = search.binarySearch(3, array, 0, length - 1);
		assertEquals(1, actual);
		int actual1 = search.linearSearch(4, array);
		assertEquals(2, actual1);

	}

	@Test
	public void testfail() {
		int array[] = { 2, 3, 4, 10, 40 };
		int length = array.length - 1;
		int actual = search.binarySearch(3, array, 0, length - 1);
		assertEquals(2, actual);
		int actual1 = search.linearSearch(4, array);
		assertEquals(2, actual1);

	}
}