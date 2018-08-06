package NestedList;

import java.util.List;

public class NestedListClass implements NestedList {
	public int depth(List<Integer> list) {
		return sumOfList(list, 1);
	}

	public static boolean isInteger(String s) {
		return isInteger(s, 10);
	}

	public static boolean isInteger(String s, int radix) {
		if (s.isEmpty()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

	@Override
	public int sumOfList(List<Integer> list, int depth) {
		if (list == null || list.size() == 0) {
			return 0;
		}
		int sum = 0;
		for (Integer value : list) {
			if (value == (int) value) {
				sum += value * depth;
			}else{
				sum +=sumOfList(value., depth+1);
			}
		}
		return 0;
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

}
