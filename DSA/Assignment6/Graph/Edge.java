package Graph;

/**
 * Edge - create edge of graph
 * @author Jitendra Chandwani
 *
 */
class Edge {
	private int source;
	private int destination;
	private int weight;

	/**
	 * Edge - initialize the value of constructor
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public Edge(int source, int destination, int weight) {
		this.setSource(source);
		this.setDestination(destination);
		this.setWeight(weight);
	}

	/**
	 * getSource
	 * @return source
	 */
	public int getSource() {
		return source;
	}

	/**
	 * setSource
	 * @param source - source to be set
	 */
	public void setSource(int source) {
		this.source = source;
	}

	/**
	 * getDestination
	 * @return Destination
	 */
	public int getDestination() {
		return destination;
	}

	/**
	 * setDestination
	 * @param destination - destination to be set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}

	/**
	 * getWeight
	 * @return Weight
	 */
	public int getWeight() {
		return weight;
	}


	/**
	 * setWeight
	 * @param weight - weight to be set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}