import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UpdateTest {
	private int numberOfRowUpdated;
	private UpdateQuery	query;

	/**
	 * initialize - initialize the object value
	 */
	@Before
	public void initialize(){
		query=new UpdateQuery();
		query.updateQuery();
		numberOfRowUpdated=query.numberOfRowUpdated;
	}


	/**
	 * To check the functionality of UpdateQuery class
	 */
	@Test
	public void numberOfRowUpdatedTest() {
		assertEquals(2, numberOfRowUpdated);
	}

}
