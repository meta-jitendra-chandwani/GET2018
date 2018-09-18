package Question2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayImplementationOfQueueTest {
	ArrayImplementationOfQueue<Integer> arrayQueue;
	/*
	 * Initialize object of ArrayImplementationOfQueue class.
	 */
	@Before
	public void initialize(){
		arrayQueue=new ArrayImplementationOfQueue<Integer>(5);
	}

	/*
	 * isQueueFullTest - test the functionality of class
	 */
	@Test
	public void isQueueFullTest() {
		arrayQueue.enQueue(10);
		arrayQueue.enQueue(10);
		arrayQueue.enQueue(10);
		arrayQueue.enQueue(10);
//		arrayQueue.enQueue(10);
//		arrayQueue.enQueue(10);
//		arrayQueue.deQueue();
		Boolean a=false;
		assertEquals(arrayQueue.isFull(), a);
	}

}
