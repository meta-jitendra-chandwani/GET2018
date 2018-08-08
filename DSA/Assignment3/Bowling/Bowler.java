
public class Bowler {

	private int bowlerIndex;
	private int quota;
	
	Bowler(int bowlerIndex, int quota){
		this.bowlerIndex = bowlerIndex;
		this.quota = quota;
	}
	
	/**
	 * 
	 * @return - index of bowler
	 */
	public int getIndex() {
		return this.bowlerIndex;
	}
	
	/**
	 * 
	 * @return - Quota of a bowler
	 */
	public int getQuota() {
		return this.quota;
	}
	
	/**
	 * Set New ball quota for bowler
	 * @param quota - updated quota for bowler
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}
}
