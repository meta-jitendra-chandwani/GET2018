import static org.junit.Assert.*;

import org.junit.Test;

public class ClumpTest {
	Clump operation = new Clump();

	@Test
	public void test() {
		int array[] = { 1, 2, 2, 3, 4, 4 };
		int actual = operation.countClumps(array);
		assertEquals(2, actual);
	}

	@Test
	public void test1() {
		int array[] = { 1, 1, 2, 1, 1 };
		int actual = operation.countClumps(array);
		assertEquals(2, actual);
	}

	@Test
	public void test2() {
		int array[] = { 1, 1, 2, 2, 1, 1 };
		int actual = operation.countClumps(array);
		assertEquals(3, actual);
	}

}
