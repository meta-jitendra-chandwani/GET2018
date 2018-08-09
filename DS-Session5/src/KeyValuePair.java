public class KeyValuePair {

	private int key;
	private String value;

	public KeyValuePair(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("{" + key + "," + value + "}");
	}
}