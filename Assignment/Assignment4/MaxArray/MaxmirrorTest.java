import static org.junit.Assert.*;
import org.junit.Test;

public class MaxmirrorTest {
	ArrOperation operation = new ArrOperation();

	@Test
	public void test() {

		int array[] = { 1, 2, 3, 8, 9, 3, 2, 1 };
		int actual = operation.maxMirror(array);
		assertEquals(3, actual);
	}

	@Test
	public void test1() {

		int array[] = { 7, 1, 4, 9, 7, 4, 1 };
		int actual = operation.maxMirror(array);
		assertEquals(2, actual);
	}

	@Test
	public void test2() {

		int array[] = { 1, 2, 1, 4 };
		int actual = operation.maxMirror(array);
		assertEquals(3, actual);
	}

	@Test
	public void test3() {
		int array[] = { 1, 4, 5, 3, 5, 4, 1 };
		int actual = operation.maxMirror(array);
		assertEquals(7, actual);
	}
}
