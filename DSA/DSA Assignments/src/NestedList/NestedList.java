package NestedList;

import java.util.*;

public interface NestedList {
	// List<Integer> list=new ArrayList<Integer>();
	// ArrayList<Integer> list1=new ArrayList<Integer>();

	int sumOfList(List<Integer> list,int depth);

	int largestValue(List<Integer> list);

	boolean searchElement(List<Integer> list, int element);
}
