/**
 * Node Class of B-Tree
 * @author Jitendra
 *
 */
public class Node {
	Pair pair;
	Node left;
	Node right;
	/**
	 * Node Class of B-Tree
	 * @param pair
	 */
	public Node(Pair pair) {
		this.pair = pair;
		this.left = null;
		this.right = null;
	}
}