package problems.tree.dfs;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/description/
 * https://takeuforward.org/data-structure/check-if-two-trees-are-identical/#google_vignette
 */

public class SameTree_TwoTreesAreIdentical {
	
	public void test() {
		/**
		 *    1                   1      
		 *   /  \               /   \
		 *  2    3             2     3
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
		System.out.println(isSameTree(root1, root2));
	}
	
	/**
	 * Time Complexity: O(N).Reason: We are doing a tree traversal.
       Space Complexity: O(N). Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null || q== null) {
			return true;
		}
		return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
