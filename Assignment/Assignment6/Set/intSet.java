package SetProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * intSet	Final Class - Set function
 */

public final class intSet implements intSetInterface {
	
	/*
	 * (non-Javadoc)
	 * @see SetProblem.intSetInterface#isMember(int, int[])
	 * @param X - element to be search in set.
	 * @param set - array which contain number 1-1000.
	 * @return true - if element is a member of set.
	 * @return false - else element is not the member of set.
	 */

	@Override
	public boolean isMember(int x, int[] set) {
		for (int value : set) {
			if (value == x) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see SetProblem.intSetInterface#size(int[])
	 * @param set - array which contain number 1-1000
	 * @return length of set array
	 */
	@Override
	public int size(int[] set) {
		return set.length;
	}
	

	/*
	 * (non-Javadoc)
	 * @see SetProblem.intSetInterface#getComplement(int[], int[])
	 * @param base array - which consist numbers of number(integer value)
	 * @param set array - universal set
	 * @return complement set of base array
	 */
	@Override
	public int[] getComplement(int[] base, int[] set) {
		List<Integer> listSet = Arrays.stream(set).boxed()
				.collect(Collectors.toList());
		List<Integer> baseSet = Arrays.stream(base).boxed()
				.collect(Collectors.toList());
		listSet.removeAll(baseSet);
		
		int result[] = listSet.stream().mapToInt(Integer::intValue).toArray();
		return result;

	}

	/*
	 * (non-Javadoc)
	 * @see SetProblem.intSetInterface#union(int[], int[])
	 * @param set1 array - which consist numbers of number(integer value)
	 * @param set2 array - which consist numbers of number(integer value)
	 * @return result array - which consist union of set.
	 */
	@Override
	public int[] union(int set1[], int set2[]) {
	
		List<Integer> listSet1 = Arrays.stream(set1).boxed()
				.collect(Collectors.toList());
		List<Integer> listSet2 = Arrays.stream(set2).boxed()
				.collect(Collectors.toList());

		listSet1.addAll(listSet2);
		Set<Integer> removeDuplicate = new HashSet<>();
		removeDuplicate.addAll(listSet1);
		listSet1.clear();
		listSet1.addAll(removeDuplicate); 
		
		int result[] = listSet1.stream().mapToInt(Integer::intValue).toArray();
		return result;
	}
	

	/*
	 * (non-Javadoc)
	 * @see SetProblem.intSetInterface#isSubset(int[], int[])
	 * @param subset array - which consist numbers of number(integer value)
	 * @param set array - Universal Set
	 * @return boolean value - true if subset value is present in set array
	 * @return boolean value - false if subset value is not present in set array
	 */
	@Override
	public boolean isSubset(int[] subset, int[] set) {
		boolean value = false;
		List<Integer> listSet1 = Arrays.stream(subset).boxed()
				.collect(Collectors.toList());
		List<Integer> listSet2 = Arrays.stream(set).boxed()
				.collect(Collectors.toList());
		if (listSet2.containsAll(listSet1)) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}

}
