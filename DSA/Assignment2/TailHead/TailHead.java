import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jitendra Chandwani
 *
 */
public class TailHead {

	/**
	 * getValue - find value at position
	 * @param list
	 * @param string
	 * @return - getElement Function
	 */
	public String getValue(List<Object> list, String position) {
		return (getElement(list, position));
	}

	/**
	 * getElement - find the element at position
	 * @param list
	 * @param position
	 * @return element value if Integer found otherwise throw error or null(if
	 *         element not found)
	 */
	public String getElement(List<Object> list, String position) {
		int value = -1;

		if (position.charAt(0) == 'T' && position.length() == 1) {
			throw new AssertionError();
		}

		else if (position.charAt(0) == 'H' && position.length() == 1) {
			if ((list.get(0)) instanceof Integer) {
				value = ((Integer) list.get(0));
				return (value + "");
			}
			throw new AssertionError("List instance found at head");
		}

		else if (position.charAt(0) == 'T') {
			list.remove(0);
			return getElement((List<Object>) list,
					position.substring(1, position.length()));
		}

		else if (position.charAt(0) == 'H') {
			return getElement((List<Object>) list.get(0),
					position.substring(1, position.length()));
		}

		return null;
	}

	public static void main(String[] args) {
		List<Object> list1 = new ArrayList<Object>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Object> list2 = new ArrayList<Object>();
		list2.add(4);
		list2.add(5);
		list2.add(6);

		List<Object> list3 = new ArrayList<Object>();
		list3.add(7);
		list3.add(8);
		list3.add(9);
		List<Object> listOfList = new ArrayList<Object>();

		listOfList.add(list1);
		listOfList.add(list2);
		listOfList.add(list3);
		TailHead head = new TailHead();
		System.out.println("Value : " + head.getValue(listOfList, "THH"));
	}
}
