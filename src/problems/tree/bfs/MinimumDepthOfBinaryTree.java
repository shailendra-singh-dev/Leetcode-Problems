package problems.tree.bfs;

import main.utilities.TreeNode;

public class MinimumDepthOfBinaryTree {

	public void test() {
		/**       3
		 *       / \          
		 *      9   20
		 *          /\     
		 *        15  7 
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
		System.out.println(minDepth(root));
	}

	public int minDepth(TreeNode root) {
		return getDepth(root);
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
        if(root.left == null){
            return 1 + getDepth(root.right);
        }
        if(root.right == null){
            return 1 + getDepth(root.left);
        }
		return Math.min(1 + getDepth(root.left), 1 + getDepth(root.right)) ;
	}

	
}
