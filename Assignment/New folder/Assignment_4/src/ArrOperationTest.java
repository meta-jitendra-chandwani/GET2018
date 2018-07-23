import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


public class ArrOperationTest {

	@Test
	public void test() {		
	        int array[] = {7, 1, 4, 9, 7, 4, 1};	        
	        ArrOperation operation = new ArrOperation();
	       int result=operation.maxMirror(array);
	       System.out.println(result);

	       assertEquals(2, result);
	}
	
	@Test
	public void test1(){
		 int array[] = {6, 1, 4, 5, 4, 1, 9};	        
	        ArrOperation operation = new ArrOperation();
	       int result=operation.maxMirror(array);
	       System.out.println(result);
	       assertEquals(5, result);
	}
	@Test
	public void test2() {		
	        int array[] = {1, 2, 1, 4};	        
	        ArrOperation operation = new ArrOperation();
	       int result=operation.maxMirror(array);
	       System.out.println(result);

	       assertEquals(3, result);
	}
	
	@Test
	public void test3(){
		 int array[] = {1, 4, 5, 3, 5, 4, 1};	        
	        ArrOperation operation = new ArrOperation();
	       int result=operation.maxMirror(array);
	       System.out.println(result);

	       assertEquals(7, result);
	}

}
