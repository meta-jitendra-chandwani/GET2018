

import java.util.*;
/*
 * NestedList interface contains number of operation to be performed on Json
 */
public interface NestedList {
	
	public long sumOfList(List<List<Long>> nestedList);

	public long largestValue(List<List<Long>> nestedList);

	boolean searchElement(List<List<Long>> nestedList, int element);
}
