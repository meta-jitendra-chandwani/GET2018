import java.util.ArrayList;
import java.util.List;
/*
 * NestedListClass - implements NestedList, and perform operation on nestedlist.
 */
public class NestedListClass implements NestedList {

	/*
	 * (non-Javadoc)
	 * @see NestedList#sumOfList(java.util.List)
	 * sumOfList - To calculate the sum of nested list
	 * @param nestedList - nested List
	 * @return - the sum of all integer in nested list
	 */
	@Override
	public int sumOfList(List<List<Integer>> nestedList) {
		int returnValue = 0;
		if (!(nestedList == null || nestedList.size() == 0)) {
			int sum = 0;
			for (Object list : nestedList) {
				if (list instanceof Integer) {
					sum += (int) list;
				} else {
					sum += sumOfList((List) list);
				}
			}
			returnValue = sum;
		}
		return returnValue;

	}

	/*
	 * (non-Javadoc)
	 * @see NestedList#largestValue(java.util.List)
	 * largestValue - To calculate the largest value from the nested list
	 * @param nestedList - nested List
	 * @return - the largest value from the nested list
	 */
	@Override
	public int largestValue(List<List<Integer>> nestedList) {
		int returnValue = 0;
		if (!(nestedList == null || nestedList.size() == 0)) {
			int maximumValueInList = 0;
			for (Object list : nestedList) {
				if (list instanceof Integer) {
					if ((int) list > maximumValueInList) {
						maximumValueInList = (int) list;
					}
				} else {
					maximumValueInList = largestValue((List) list);
				}
			}
			returnValue = maximumValueInList;
		}
		return returnValue;
	}

	/*
	 * (non-Javadoc)
	 * @see NestedList#searchElement(java.util.List, int)
	 * searchElement - Search the element in the nested list
	 * @param nestedList - nested list
	 * @param element - the element to be search in the list
	 * @return - boolean value - true if element is search else false.
	 */
	@Override
	public boolean searchElement(List<List<Integer>> nestedList, int element) {
		boolean returnValue = false;
		if (!(nestedList == null || nestedList.size() == 0)) {
			for (Object list : nestedList) {
				if (list instanceof Integer) {
					if ((int) list == element) {
						returnValue = true;
						break;
					}
				} else {
					if (!returnValue) {
						returnValue = searchElement((List) list, element);
					}
				}
			}
		}
		return returnValue;
	}

	public static void main(String[] arg) {

		List<List<Integer>> list = new ArrayList<>();
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

		NestedListClass operation = new NestedListClass();
		System.out.println("Sum of the lists : " + operation.sumOfList(list));
		System.out.println("largest value from the list : " + operation.largestValue(list));
		System.out.println("Search 11  from the list: " + operation.searchElement(list, 11));

	}

}