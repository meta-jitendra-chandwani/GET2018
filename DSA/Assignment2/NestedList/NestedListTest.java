import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NestedListTest {
	private NestedListClass nestedListClass;
	private List<List<Integer>> list;
	@Before
	public void initialize() {
		list = new ArrayList<>();
		List<Integer> nestedList = new ArrayList<Integer>();
		List<Integer> nestedList1 = new ArrayList<Integer>();
		List<Integer> nestedList2 = new ArrayList<Integer>();

		nestedList.add(1);
		nestedList.add(2);
		nestedList.add(3);
		nestedList.add(4);

		nestedList1.add(5);
		nestedList1.add(6);
		nestedList1.add(7);
		nestedList1.add(8);

		nestedList2.add(9);
		nestedList2.add(10);
		nestedList2.add(11);
		nestedList2.add(12);

		list.add(nestedList);
		list.add(nestedList1);
		list.add(nestedList2);
		nestedListClass = new NestedListClass();
	}

	@Test
	public void sumOfListTest() {
		assertEquals(nestedListClass.sumOfList(list),78);
	}
	
	@Test
	public void largestElementsOfListTest() {
		assertEquals(nestedListClass.largestValue(list),12);
	}
	
	@Test
	public void searchElementFromList() {
		assertEquals(nestedListClass.searchElement(list, 14),false);
	}

}
