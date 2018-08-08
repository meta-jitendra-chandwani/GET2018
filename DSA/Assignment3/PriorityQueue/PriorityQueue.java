
public interface PriorityQueue {

	/**
	 * Insert a value in priority key
	 * @param value -  integer type value
	 */
	public void insert(int value);
	
	/**
	 * 
	 * @return - highest  priority value
	 */
	public int peek();
	
	/**
	 * Remove top priority value and return it
	 * @return - return removed value
	 */
	public int pop();
	
	/**
	 * Update Heap after increase value at index
	 * @param index - index of value
	 * @param newValue - new value 
	 */
	public void increaseKey(int index, int newValue);
	
	/**
	 * 
	 * @return - true if Queue is empty otherwise false
	 */
	public boolean isEmpty();
	
}
