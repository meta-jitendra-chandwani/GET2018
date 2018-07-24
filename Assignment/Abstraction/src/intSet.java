import java.util.Arrays;
import java.util.List;

public final class intSet implements intSetInterface {

	@Override
	public boolean isMember(int x, int[] set) {
		for (int value : set) {
			if (value == x) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size(int[] set) {
		return set.length;
	}

	@Override
	public List<int[]> getComplement(int[] base, int[] set) {
		List<int[]> listSet = Arrays.asList(set);
		List<int[]> baseSet = Arrays.asList(base);
		listSet.removeAll(baseSet);

		return listSet;

	}

	@Override
	public List<int[]> union(int[] set1, int[] set2) {
		List<int[]> listSet1 = Arrays.asList(set1);
		List<int[]> listSet2 = Arrays.asList(set2);
		listSet1.addAll(listSet2);
		return listSet1;
	}

	@Override
	public boolean isSubset(int[] subset, int[] set) {
		
		return false;
	}

}
