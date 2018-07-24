import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArrOperationTest {
	 @Rule
     public ExpectedException thrown= ExpectedException.none();

//	// Positve maxMirror Test Case
//	@Test
//	public void maxMirrorTest() {
//		int array[] = { 1, 2, 3, 8, 9, 3, 2, 1 };
//		int actual = operation.maxMirror(array);
//		assertEquals(3, actual);
//	}
//
//	@Test
//	public void maxMirrorTest2() {
//		int array[] = { 7, 1, 4, 9, 7, 4, 1 };
//		int actual = operation.maxMirror(array);
//		assertEquals(2, actual);
//	}
//
//	@Test
//	public void maxMirrorTest3() {
//		int array[] = { 1, 2, 1, 4 };
//		int actual = operation.maxMirror(array);
//		assertEquals(3, actual);
//	}
//
//	@Test
//	public void maxMirrorTest4() {
//		int array[] = { 1, 4, 5, 3, 5, 4, 1 };
//		int actual = operation.maxMirror(array);
//		assertEquals(7, actual);
//	}
//
//	// Negative maxMirror Test Case
//	@Test
//	public void maxMirrorTest5() {
//		int array[] = { 1, 4, 5, 1 };
//		int actual = operation.maxMirror(array);
//		assertNotEquals(0, actual);
//	}
//
//	@Test
//	public void maxMirrorTest6() {
//		int array[] = { 7, 1, 7, 4, 1 };
//		int actual = operation.maxMirror(array);
//		assertNotEquals(4, actual);
//	}
//
//	@Test
//	public void maxMirrorTest7() {
//		int array[] = { 1, 2, 4, 4, 1 };
//		int actual = operation.maxMirror(array);
//		assertNotEquals(3, actual);
//	}
//
//	// Positive Test Case of count Clump
//	@Test
//	public void countClumpTest() {
//		int array[] = { 1, 2, 2, 3, 4, 4 };
//		int actual = operation.countClumps(array);
//		assertEquals(2, actual);
//	}
//
//	@Test
//	public void countClumpTest2() {
//		int array[] = { 1, 1, 2, 1, 1 };
//		int actual = operation.countClumps(array);
//		assertEquals(2, actual);
//	}
//
//	@Test
//	public void countClumpTest3() {
//		int array[] = { 1, 1, 1, 1 };
//		int actual = operation.countClumps(array);
//		assertEquals(1, actual);
//	}

	// Negative Test Case of count Clump
	@Test
	public void countClumpTest4() {
		ArrOperation operation = new ArrOperation();
		int array[] = {};
		try{
			int actual = operation.countClumps(array);
		}
		catch(AssertionError e){
			thrown.expect(AssertionError.class);
			thrown.expectMessage("Array is empty");
		}
//		assertNotEquals(2, actual);
		
		
//		throw new NullPointerException("Array is empty");
	}

//	@Test
//	public void countClumpTest5() {
//		int array[] = { 1, 1, 2, 2, 1, 1, 2, };
//		int actual = operation.countClumps(array);
//		assertNotEquals(2, actual);
//	}
//
//	@Test
//	public void countClumpTest6() {
//		int array[] = { -1, -1, 1, 1 };
//		int actual = operation.countClumps(array);
//		assertNotEquals(1, actual);
//	}
//	
//	// Positive Test Case of FIND XY
//	@Test
//	public void findXYTest() {
//		int array[] = { 1, 4, 1, 5, 5, 4, 1 };
//		int result[] = operation.findXY(array, 4, 5);
//		int expected[] = { 1, 4, 5, 1, 1, 4, 5 };
//		assertArrayEquals(expected, result);
//	}
//
//	@Test
//	public void findXYTest2() {
//		int array[] = { 5, 4, 9, 4, 9, 5 };
//		int result[] = operation.findXY(array, 4, 5);
//		int expected[] = { 9, 4, 5, 4, 5, 9 };
//		assertArrayEquals(expected, result);
//	}
//
//	@Test
//	public void findXYTest3() {
//		int array[] = { 1, 4, 1, 5 };
//		int result[] = operation.findXY(array, 4, 5);
//		int expected[] = { 1, 4, 5, 1 };
//		assertArrayEquals(expected, result);
//	}
//
//	// Positive Test Case of FIND XY
//	@Test
//	public void findXYTest4() {
//		int array[] = { 1, 4, 1, 5, 5, 4, 1 };
//		int result[] = operation.findXY(array, 4, 5);
//		int expected[] = { 1, 4, 5, 1, 1, 4, 5 };
//		assertArrayEquals(expected, result);
//	}
//
//	@Test
//	public void findXYTest5() {
//		int array[] = { 5, 4, 9, 4, 9, 5 };
//		int result[] = operation.findXY(array, 4, 5);
//		int expected[] = { 9, 4, 5, 4, 5, 9 };
//		assertArrayEquals(expected, result);
//	}
//
////	@Test
////	public void findXYTest6() {
////		int array[] = {};
////		operation.findXY(array, 4, 5);
////		thrown.expectMessage("Array is not full fill the prerequisite");
////
////	}
//	@Test
//	public void splitArray() {
//		int array[] = { 1, 1, 1, 2, 1 };
//		int actual = operation.splitArray(array);
//		assertEquals(3, actual);
//	}
//
//	@Test
//	public void splitArray2() {
//		int array[] = { 2, 1, 1, 2, 1 };
//		int actual = operation.splitArray(array);
//		assertEquals(-1, actual);
//	}
//
//	@Test
//	public void splitArray3() {
//		int array[] = { 10, 10 };
//		int actual = operation.splitArray(array);
//		assertEquals(1, actual);
//	}

}
