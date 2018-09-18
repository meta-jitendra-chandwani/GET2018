/**
 * Pair class contain a pack of key and value
 * @author Jitendra
 *
 */
public class Pair {
	private int key;
	private String value;

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * getKey
	 * @return -  key
	 */
	int getKey(){
		return key;
	}
	
	/**
	 * getValue
	 * @return - value
	 */
	String getValue(){
		return value;
	}
}