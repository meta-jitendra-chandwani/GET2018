import static org.junit.Assert.*;

import org.junit.Test;


public class SplitarrayTest {

	
	Splitarray split=new Splitarray();
	@Test
	public void test() {
		
		int array[] = { 1, 1, 1, 2, 1 };
		int actual = split.splitArray(array);
		assertEquals(3, actual);
	}
	@Test
	public void test1() {
		
		int array[] = { 2, 1, 1, 2, 1 };
		int actual = split.splitArray(array);
		assertEquals(-1, actual);
	}
	@Test
	public void test2() {
		
		int array[] = {10, 10};
		int actual = split.splitArray(array);
		assertEquals(1, actual);
	}
}
