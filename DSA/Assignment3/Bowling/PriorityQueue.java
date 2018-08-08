
public interface PriorityQueue {

	/**
	 * Insert a value in priority key
	 * @param value -  integer type value
	 */
	public void insert(Bowler bowler);
	
	/**
	 * 
	 * @return - highest  priority value
	 */
	public Bowler peek();
	
	/**
	 * Remove top priority value and return it
	 * @return - return removed value
	 */
	public Bowler pop();
	
	/**
	 * 
	 * @return - true if Queue is empty otherwise false
	 */
	public boolean isEmpty();
	
}
