package problems.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode.com/discuss/interview-question/1408203/2-bfs-for-graphs
 * 
 * @author ShSingh
 */

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrderV1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<Integer> rootList= new ArrayList<Integer>();
		rootList.add(root.data);
		result.add(rootList);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			ArrayList<Integer> children = new ArrayList<>();
			if (node.left != null) {
				queue.add(node.left);
				children.add(node.left.data);
			}
			if (node.right != null) {
				queue.add(node.right);
				children.add(node.right.data);
			}
			if (!children.isEmpty())
				result.add(children);
		}
		System.out.println(result);
		return result;
	}

	public List<List<Integer>> levelOrderV2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> queue = new LinkedList<>();
		// queue.add(root);
		queue.offer(root);
		ArrayList<Integer> rootList= new ArrayList<Integer>();
		rootList.add(root.data);
		result.add(rootList);

		while (!queue.isEmpty()) {
			int childrenSize = queue.size();
			ArrayList<Integer> children = new ArrayList<>();
			TreeNode node = queue.poll();
			for (int i = 0; i < childrenSize; i++) {
				if (node.left != null) {
					queue.add(node.left);
					children.add(node.left.data);
				}
				if (node.right != null) {
					queue.add(node.right);
					children.add(node.right.data);
				}
				if (!children.isEmpty())
					result.add(children);
			}
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

		System.out.println(levelOrderV2(root));

	}
}
