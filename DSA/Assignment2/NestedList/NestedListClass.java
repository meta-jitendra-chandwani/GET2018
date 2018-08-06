

import java.util.ArrayList;
import java.util.List;

public class NestedListClass implements NestedList {

	@Override
	public int sumOfList(List<List<Integer>> list) {
		int returnValue = 0;
		if (list == null || list.size() == 0) {
			returnValue = 0;
		} else {
			int sum = 0;
			for (List<Integer> nestedlist : list) {
				for (Integer listValue : nestedlist) {
					sum += listValue;
				}
			}
			returnValue = sum;
		}
		return returnValue;
	}

	@Override
	public int largestValue(List<Integer> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean searchElement(List<Integer> list, int element) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String []arg){

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> nestedList = new ArrayList<Integer>();
		List<Integer> nestedList1 = new ArrayList<Integer>();

		nestedList.add(4);
		nestedList.add(1);
		nestedList.add(2);
		nestedList.add(3);

		nestedList1.add(4);
		nestedList1.add(5);
		nestedList1.add(2);
		nestedList1.add(3);

		list.add(nestedList);
		list.add(nestedList1);
		
		NestedListClass class1 = new NestedListClass();
		System.out.println("Sum : " + class1.sumOfList(list));

	}

}