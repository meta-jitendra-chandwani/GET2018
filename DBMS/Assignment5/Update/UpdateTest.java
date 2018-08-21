import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UpdateTest {
	private int numberOfRowUpdated;
	private UpdateQuery	query;

	@Before
	public void initailize(){
		query=new UpdateQuery();
		query.updateQuery();
		numberOfRowUpdated=query.numberOfRowUpdated;
	}

	@Test
	public void test() {
		assertEquals(2, numberOfRowUpdated);
	}

}
