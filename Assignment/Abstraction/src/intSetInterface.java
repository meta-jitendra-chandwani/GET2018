import java.util.List;


public interface intSetInterface {
	boolean isMember(int x,int set[]);
	int size(int set[]);
	boolean isSubset(int subset[],int set[]);
	 List<int[]> getComplement(int base[],int set[] );	
	 List<int[]> union(int set1[], int set2[]);

}
