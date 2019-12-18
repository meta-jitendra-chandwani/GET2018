package areas;

import java.util.Scanner;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int newData) {
		data = newData;
		left = null;
		right = null;
	}
}

public class BST {

	TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			TreeNode newNode = new TreeNode(data);
			return newNode;
		} else {
			if (data <= root.data)
				root.left = insert(root.left, data);
			else
				root.right = insert(root.right, data);
			return root;
		}
	}

	void preorder(TreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	TreeNode search(TreeNode root, int keyValue) {
		if (keyValue == root.data) {
			return root;
		} else if (keyValue < root.data) {
			return search(root.left, keyValue);
		} else {
			return search(root.right, keyValue);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		TreeNode root = null;
		BST tree = new BST();
		int N = s.nextInt();
		for (int i = 0; i < N; i++) {
			root = tree.insert(root, s.nextInt());
		}
		int subTreeElement = s.nextInt();
		TreeNode subTree = tree.search(root, subTreeElement);
		tree.preorder(subTree);

	}
}