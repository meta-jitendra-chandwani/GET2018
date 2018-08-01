package SetProblem;


public interface intSetInterface {
	boolean isMember(int x, int set[]);

	int size(int set[]);

	boolean isSubset(int subset[], int set[]);

	int[] getComplement(int base[], int set[]);

	int[] union(int set1[], int set2[]);

}
