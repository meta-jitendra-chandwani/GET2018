import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Jitendra DictionaryTree - implements {@link DictionaryInterface}
 */
public class DictionaryTree implements DictionaryInterface {
	Node root;

	/**
	 * addRecursive - recursively call function itself to create tree
	 * @param current - current node
	 * @param pair - key value pair
	 * @return Complete binary search tree
	 */
	private Node addRecursive(Node current, Pair pair) {
		if (current == null) {
			return new Node(pair);
		}
		if (pair.getKey() < current.pair.getKey()) {
			current.left = addRecursive(current.left, pair);
		} else if (pair.getKey() > current.pair.getKey()) {
			current.right = addRecursive(current.right, pair);
		} else {
			return current;
		}
		return current;
	}

	/**
	 * sortedListOfNode - sort the node in ascending order
	 * @return sortedlist of node
	 */
	private ArrayList<Pair> sortedListOfNode() {
		ArrayList<Pair> sortedList = new ArrayList<Pair>();
		sortedList = JsonParser.nodeList();
		Collections.sort(sortedList, new Comparator<Pair>() {

			/**
			 * @param - Pair o1
			 * @param - Pair o2
			 */
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.getKey() - o2.getKey();
			}
		});
		return sortedList;
	}

	/**
	 * deleteRecursive - delete node from tree recursively
	 * @param current - current node of tree
	 * @param pairKey - pair of key value to be deleted from tree
	 * @return - binary tree after delete the pair node
	 * @throws NodeNotFoundException
	 */
	private Node deleteRecursive(Node current, Pair pairKey) {
		if (current == null)
			return current;

		if (pairKey.getKey() < current.pair.getKey())
			current.left = deleteRecursive(current.left, pairKey);
		else if (pairKey.getKey() > current.pair.getKey())
			current.right = deleteRecursive(current.right, pairKey);
		else {
			if (current.pair.getValue().equals(pairKey.getValue())) {
				if (current.left == null) {
					return current.right;
				} else if (current.right == null) {
					return current.left;
				}
				current.pair = getMinNode(current.right);
				root.right = deleteRecursive(current.right, pairKey);
			}
		}
		return current;
	}

	/**
	 * getValueOfKey - find value of particular key
	 * @param current
	 * @param key
	 * @return Node of that key
	 */
	private Node getValueOfKey(Node current, int key) {
		if (current == null)
			return current;

		if (key < current.pair.getKey()) {
			current = getValueOfKey(current.left, key);
		} else if (key > current.pair.getKey()) {
			current = getValueOfKey(current.right, key);
		}
		return current;
	}

	/**
	 * getMinNode - find the minimum successor of node
	 * @param root - root node of tree
	 * @return minimum Pair node
	 */
	private Pair getMinNode(Node root) {
		Pair pair;
		int minValueOfKey = root.pair.getKey();
		String ValueOfKey = root.pair.getValue();
		while (root.left != null) {
			minValueOfKey = root.left.pair.getKey();
			ValueOfKey = root.left.pair.getValue();
			root = root.left;
		}
		pair = new Pair(minValueOfKey, ValueOfKey);
		return pair;
	}

	/**
	 * nodesInBTree - count number of node in B-Tree
	 * @param root
	 * @return number of node
	 */
	private int nodesInBTree(Node root) {
		if (null == root) {
			return 0;
		}
		int nLeftSubtree = nodesInBTree(root.left);
		int nRightSubtree = nodesInBTree(root.right);
		return nLeftSubtree + nRightSubtree + 1;
	}

	/**
	 * (non-Javadoc)
	 * @see DictionaryInterface#add(Pair) add - add pair into the B-Tree
	 * @param Pair - pair of key value
	 */
	@Override
	public void add(Pair pair) {
		root = addRecursive(root, pair);
	}

	/**
	 * (non-Javadoc)
	 * @see DictionaryInterface#delete(Pair)
	 * @param pairKey - the pair to be deleted from B-Tree
	 * @return remaining number of node in tree after deletions
	 */
	@Override
	public int delete(Pair pairKey) throws NodeNotFoundException {
		int initial = nodesInBTree(root);
		root = deleteRecursive(root, pairKey);
		if (initial == nodesInBTree(root)) {
			throw new NodeNotFoundException("There is no such kind of node");
		} else {
			return nodesInBTree(root);
		}
	}

	/**
	 * (non-Javadoc)
	 * @see DictionaryInterface#getValue(int)
	 * @param - key
	 * @return - value of particular key
	 */
	@Override
	public String getValue(int key) {
		return getValueOfKey(root, key).pair.getValue();
	}

	/**
	 * (non-Javadoc)
	 * @see DictionaryInterface#sortedKeyValue()
	 * @return - list of sorted b-tree node
	 */
	@Override
	public ArrayList<Pair> sortedKeyValue() {
		return sortedListOfNode();
	}

	/**
	 * (non-Javadoc)
	 * @see DictionaryInterface#sortedKeyValuePair(int, int)
	 * @param Key1 - Boundary Key1
	 * @param Key2 - Boundary Key2
	 * @return List of sorted list according to boundary condition
	 */
	@Override
	public ArrayList<Pair> sortedKeyValuePair(int Key1, int Key2) {
		ArrayList<Pair> sortedList;
		ArrayList<Pair> sortedListWithBoundaryCondition = null;
		try{
			sortedList = sortedListOfNode();
			sortedListWithBoundaryCondition = new ArrayList<Pair>();
			for (int i = 0; i < sortedList.size(); i++) {
				if (sortedList.get(i).getKey() >= Key1
						&& sortedList.get(i).getKey() <= Key2) {
					sortedListWithBoundaryCondition.add(sortedList.get(i));
				}
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		
		return sortedListWithBoundaryCondition;
	}
}