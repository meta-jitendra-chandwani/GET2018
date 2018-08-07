import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class NestedListTest {
	private NestedListClass operation;
	private List<List<Long>> nestedList;
	
	/*
	 * Initialize object of NestedListClass class.
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void initialize() {
		operation = new NestedListClass("C:\\Users\\User23\\workspace\\Area\\src\\InputFile.json");
		nestedList=operation.JsonParser();
	}

	/*
	 * sumOfListTest - test the sum of list functionality of the class
	 */
	@Test
	public void sumOfListTest() {
		assertEquals(operation.sumOfList(nestedList),28);
	}
	
	/*
	 * largestListValueTest - test the largest value find functionality of class
	 */
	@Test
	public void largestListValueTest() {
		assertEquals(operation.largestValue(nestedList),7);
	}
	
	/*
	 * searchElementTest - test the search functionality of class
	 */
	@Test
	public void searchElementTest() {
		assertEquals(operation.searchElement(nestedList,2),true);
	}

}
