import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AssignmentTest {
	private List<AssignmentPOJO> connectionList;
	private List<String> actualParent;
	private List<String> expectedParent;

	private List<Integer> actualCount;
	private List<Integer> expectedCount;

	/**
	 * initialize - initialize the object value
	 */
	@Before
	public void initialize() {
		connectionList = Assignment.getPojoList();
		actualParent = new ArrayList<String>();
		actualParent.add("Fashion");
		actualParent.add("Gadgets");

		actualCount = new ArrayList<Integer>();
		actualCount.add(1);
		actualCount.add(3);

		expectedParent = new ArrayList<String>();
		for (int i = 0; i < connectionList.size(); i++) {
			expectedParent.add(connectionList.get(0).getParent());
		}

		expectedCount = new ArrayList<Integer>();
		for (int i = 0; i < connectionList.size(); i++) {
			expectedCount.add(connectionList.get(0).getNumberOfChild());
		}

	}

	/**
	 * To check the functionality 
	 */
	@Test
	public void parentTestCase() {
		for (int i = 0; i < connectionList.size(); i++) {
			assertEquals(expectedParent.get(i), actualParent.get(i));
		}
	}

	/**
	 * To check the functionality 
	 */
	@Test
	public void childTestCase() {
		for (int i = 0; i < connectionList.size(); i++) {
			assertEquals(expectedCount.get(i),
					actualCount.get(i));
		}
	}

}
