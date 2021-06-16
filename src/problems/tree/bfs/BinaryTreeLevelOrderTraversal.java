package problems.tree.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode.com/discuss/interview-question/1408203/2-bfs-for-graphs
 * 
 * @author ShSingh
 *
 */

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			ArrayList<Integer> children = new ArrayList<>();
			if(node.getLeftNode()!= null) {
				queue.add(node.getLeftNode());
				children.add(node.getLeftNode().data);
			}
			if(node.getRightNode()!= null) {
				queue.add(node.getRightNode());
				children.add(node.getRightNode().data);
			}		
			if(!children.isEmpty())
				result.add(children);
		}
		return result;
	}	
	
	public void test() {
		/**
		 *           3
		 *          / \
		 *   	  10   20
		 *   		  /  \	
		 *			15    7
		 *     
		 **/
		
		TreeNode root = new TreeNode(3);
		TreeNode node_2 = new TreeNode(10);
		TreeNode node_3 = new TreeNode(20);
		TreeNode node_4 = new TreeNode(15);
		TreeNode node_5 = new TreeNode(7);
		
		root.setRightNode(node_3);
		root.setLeftNode(node_2);
		
		node_3.setRightNode(node_4);
		node_3.setLeftNode(node_5);
		
		System.out.println(levelOrder(root));
		
	}
}
