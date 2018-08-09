
public interface DictionaryInterface{

	boolean add(String key,String value);
	boolean delete(String key);
	boolean get(String key);
	String sortedList();
	String sortedListBetween(String key1,String key2);
}
