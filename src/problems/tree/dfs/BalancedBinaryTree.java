package problems.tree.dfs;

import main.utilities.TreeNode;

public class BalancedBinaryTree {

	private boolean isBalanced = false;

	public void test() {
		/**
		 *         3 
		 *        / \ 
		 *       9  20 
		 *          / \ 
		 *         15  7
		 */
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		System.out.println(getHeight(root));
		System.out.println(isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
	}

	int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftDepth = 0, rightDepth = 0;
		if (null != root.left)
			leftDepth = getHeight(root.left);
		if(leftDepth == -1)
			return -1;
		
		if (null != root.right)
			rightDepth = getHeight(root.right);
		if(rightDepth == -1)
			return -1;
		
		if(Math.abs(rightDepth-leftDepth)>1)
			return -1;				
		
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
