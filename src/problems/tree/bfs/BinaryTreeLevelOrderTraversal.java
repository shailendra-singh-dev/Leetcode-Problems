package problems.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode.com/discuss/interview-question/1408203/2-bfs-for-graphs
 */

public class BinaryTreeLevelOrderTraversal {

	/**
	 * Time Complexity: O(N)
	   Space Complexity: O(N)
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root); // queue.add(root);

		while (!queue.isEmpty()) {
			int childrenSize = queue.size();
			ArrayList<Integer> subList = new ArrayList<>();
			for (int i = 0; i < childrenSize; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				subList.add(node.data);
			}			
			result.add(subList);
		}
		return result;
	}

	public void test() {
		/**
		 *     3 
		 *   /  \ 
		 * 10    20 
		 *      /  \ 
		 *     15   7
		 * 
		 **/

		TreeNode root = new TreeNode(3);
		TreeNode node_2 = new TreeNode(10);
		TreeNode node_3 = new TreeNode(20);
		TreeNode node_4 = new TreeNode(15);
		TreeNode node_5 = new TreeNode(7);

		root.setLeftNode(node_2);
		root.setRightNode(node_3);

		node_3.setLeftNode(node_4);
		node_3.setRightNode(node_5);

		System.out.println(levelOrder(root));

	}
}
