package Assignment2.Session2;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingArrayTest {
	CircularQueue<Integer> circularQueue;

	public QueueUsingArrayTest() {
		circularQueue = new CircularQueue<Integer>(8);
		circularQueue.enqueue(15);
		circularQueue.enqueue(16);
		circularQueue.enqueue(17);
		circularQueue.enqueue(18);
		circularQueue.enqueue(19);
		circularQueue.enqueue(20);
		circularQueue.enqueue(21);
		circularQueue.enqueue(22);
	}

	@Test
	public void QueueFullTest() {
		assertEquals(circularQueue.isFull(), true);
	}

	@Test
	public void DequeTest() {
		assertEquals((int) circularQueue.dequeue(), 15);
	}

	@Test
	public void QueueEmptyTest() {
		assertEquals(circularQueue.isEmpty(), false);
	}

}
