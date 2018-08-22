import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AssignmentTest {
	private int numberOfRowUpdated;
	private Assignment	query;

	/**
	 * initialize - initialize the object value
	 */
	@Before
	public void initailize(){
		query=new Assignment();
		query.procedureQuery();
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
