import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinPriorityQueueTest {

	@Test
	void test() {
		PriorityQueue pq = new MinPriorityQueue(5);
		try {
			pq.insert(13);
			pq.insert(283);
			pq.insert(123);
			pq.insert(342);
			pq.insert(10);
			Assertions.assertEquals(10, pq.peek(), "Wrong answer");
			pq.increaseKey(5, 1);
			Assertions.assertEquals(1, pq.peek(), "Wrong answer");
			pq.pop();
			Assertions.assertEquals(10, pq.pop(), "Wrong answer");
			Assertions.assertEquals(13, pq.pop(), "Wrong answer");
			Assertions.assertEquals(123, pq.pop(), "Wrong answer");
			Assertions.assertEquals(342, pq.pop(), "Wrong answer");
			Assertions.assertTrue(pq.isEmpty());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

}
