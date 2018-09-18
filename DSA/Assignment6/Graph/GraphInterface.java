package Graph;
/**
 * GraphInterface - operation of graph
 * @author Jitendra Chandwani
 *
 */
public interface GraphInterface {

	boolean isConnected();
	void reachable(int source);
	void minimumSpanningTree();
	void shortestPath(int source);
}
