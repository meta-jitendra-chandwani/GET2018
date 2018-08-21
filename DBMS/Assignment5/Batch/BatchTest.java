import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BatchTest {
	private int numberOfRowUpdated;
	private Batch BatchTest;

	@Before
	public void initailize(){
		BatchTest=new Batch();
		BatchTest.batchProcessing();
		numberOfRowUpdated=BatchTest.numberOfRowUpdated;
	}

	@Test
	public void test() {
		assertEquals(6, numberOfRowUpdated);
	}

}
