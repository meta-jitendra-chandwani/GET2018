import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CricketProblemTest {

	private CricketProblem cp = new CricketProblem();
	
	@Test
	void test1() {
		int numberOfBowler = 5;
		int numberOfBalls = 30;
		int quotaList[] = {10, 7, 23, 9, 8};
		int expected[] = {3, 1, 3, 4, 3, 1, 5, 1, 4, 2, 3, 2, 1};
		Assertions.assertArrayEquals(expected, cp.strategy(numberOfBowler, numberOfBalls, quotaList));
	}

	@Test
	void test2() {
		int numberOfBowler = 10;
		int numberOfBalls = 50;
		int quotaList[] = {12, 1, 22, 9, 18, 4, 23, 2, 20, 6};
		int expected[] = {7, 3, 7, 9, 3, 7, 9, 7, 5, 3, 5, 7, 9, 7, 5, 3, 5, 7, 9, 7, 5, 3, 5, 7, 9, 7, 5, 3, 1, 3, 7, 9, 5, 9, 3, 1, 7};
		Assertions.assertArrayEquals(expected, cp.strategy(numberOfBowler, numberOfBalls, quotaList));
	}
}
