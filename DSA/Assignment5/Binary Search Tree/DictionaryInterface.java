import java.util.List;

/**
 * 
 * @author Jitendra
 * DictionaryInterface - operation to be performed on B-Tree
 */
public interface DictionaryInterface {
	void add(Pair pair);
	int delete(Pair pairKey) throws NodeNotFoundException;
	String getValue(int key);
	List<Pair> sortedKeyValue();
	List<Pair> sortedKeyValuePair(int Key1,int Key2);
}
