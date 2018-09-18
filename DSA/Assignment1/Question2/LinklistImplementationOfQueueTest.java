package Question2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinklistImplementationOfQueueTest {
	LinkllistImplementationOfQueue<Integer> queue;

	/*
	 * Initialize object of LinkllistImplementationOfQueue class.
	 */
	@Before
	public void initialization() {
		queue = new LinkllistImplementationOfQueue<Integer>();

	}

	/*
	 * queueIsEmptyTest - test the functionality of class
	 */
	@Test
	public void queueIsEmptyTest() {
		queue.enQueue(10);
		queue.enQueue(20);
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		assertEquals(queue.isEmpty(), false);
	}

}
