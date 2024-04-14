package problems.tree.dfs;

import main.utilities.TreeNode;

public class Height_MaximumDepth_OfABinaryTree {

	public void test() {
		/**
		 *   1           1 
		 *  / \         / \ 
		 * 2   3       2   3
		 * 
		 **/

		TreeNode root1 = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		root1.setLeftNode(node_2);
		root1.setRightNode(node_3);

		root2.setLeftNode(node2);
		root2.setRightNode(node3);

		System.out.println(root1);
		System.out.println(root2);
		System.out.println(maxDepth(root1));
	}

	public int maxDepth(TreeNode root) {
		return getDepth(root);
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + getDepth(root.right);
		}
		if (root.right == null) {
			return 1 + getDepth(root.left);
		}
		return Math.max(1 + getDepth(root.left), 1 + getDepth(root.right));
	}

	public int getDepthV1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepthV1(root.left), getDepthV1(root.right)) + 1;
	}

	public int getDepthV2(TreeNode root) {
		if (root == null)
			return 0;

		int leftDepth = 0;
		if (root.left != null) {
			leftDepth = getDepthV2(root.left);
		}

		int rightDepth = 0;
		if (root.right != null) {
			rightDepth = getDepthV2(root.right);
		}
		return (Math.max(leftDepth, rightDepth) + 1);
	}
}
