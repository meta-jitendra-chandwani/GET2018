import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BatchTest {
	private int numberOfRowUpdated;
	private Batch BatchTest;

	/**
	 * initialize - initialize the object value
	 */
	@Before
	public void initialize(){
		BatchTest=new Batch();
		BatchTest.batchProcessing();
		numberOfRowUpdated=BatchTest.numberOfRowUpdated;
	}

	/**
	 * To check the functionality of Batch class
	 */
	@Test
	public void numberOfRowUpdatedTest() {
		assertEquals(6, numberOfRowUpdated);
	}

}
