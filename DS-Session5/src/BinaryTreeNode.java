import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {
	List<KeyValuePair> binaryTreeNode = new ArrayList<KeyValuePair>();
	List<BinaryTreeNode> binaryTreeLeftList = new ArrayList<BinaryTreeNode>();
	List<BinaryTreeNode> binaryTreeRightList = new ArrayList<BinaryTreeNode>();
	public BinaryTreeNode rootNode, leftNode, rightNode;
	int part1;
	String part2;

	public BinaryTreeNode(List<KeyValuePair> binaryTreeNode) {
		this.binaryTreeNode = binaryTreeNode;
		rootNode=new BinaryTreeNode();
	}

	public BinaryTreeNode(KeyValuePair objct) {
		rootNode.part1 = objct.getKey();
		rootNode.part2 = objct.getValue();
		return rootNode;
	}

	
	void createTree() {
		rootNode=TreeNode(binaryTreeNode.get(0));
		for (KeyValuePair node : binaryTreeNode) {
			if (node.getKey() >= rootNode.part1) {
				rightNode = TreeNode(node);
				binaryTreeRightList.add(rightNode);
			} else {
				leftNode = TreeNode(node);
				binaryTreeLeftList.add(leftNode);
			}
		}

		System.out.println("Left Node Elements : " + binaryTreeLeftList);
		System.out.println("Right Node Elements : " + binaryTreeRightList);
	}
}
