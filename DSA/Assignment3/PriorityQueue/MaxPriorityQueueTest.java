import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxPriorityQueueTest {

	@Test
	void test() {
		PriorityQueue pq = new MaxPriorityQueue(5);
		try {
			pq.insert(23);
			pq.insert(29);
			pq.insert(2);
			pq.insert(200);
			pq.insert(1);
			Assertions.assertEquals(200, pq.peek(), "Wrong answer");
			pq.increaseKey(5, 1000);
			Assertions.assertEquals(1000, pq.peek(), "Wrong answer");
			pq.pop();
			Assertions.assertEquals(200, pq.pop(), "Wrong answer");
			Assertions.assertEquals(29, pq.pop(), "Wrong answer");
			Assertions.assertEquals(23, pq.pop(), "Wrong answer");
			Assertions.assertEquals(2, pq.pop(), "Wrong answer");
			Assertions.assertTrue(pq.isEmpty());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

}
