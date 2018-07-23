import static org.junit.Assert.*;

import org.junit.Test;


public class FindTest {
	
	Find find=new Find();

	@Test
	public void test() {		
		int array[]={1, 4, 1, 5, 5, 4, 1};
		int result[]=find.findXY(array, 4, 5);
		int expected[]={1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test1() {
		int array[]={5, 4, 9, 4, 9, 5};
		int result[]=find.findXY(array, 4, 5);
		int expected[]={9, 4, 5, 4, 5, 9};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test3() {
		int array[]={1, 4, 1, 5};
		int result[]=find.findXY(array, 4, 5);
		int expected[]={1, 4, 5, 1};
		assertArrayEquals(expected, result);
	}
	

}
