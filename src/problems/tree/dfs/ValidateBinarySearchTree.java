package problems.tree.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * @author ShSingh
 */
public class ValidateBinarySearchTree {
	
	public void test() {
		/**
		 *           2
		 *          / \
		 *   	   1   3
		 */
		
		
		TreeNode root = new TreeNode(2);
		TreeNode node_2 = new TreeNode(1);
		TreeNode node_3 = new TreeNode(3);
		root.setRightNode(node_3);
		root.setLeftNode(node_2);
		
		
		/**
		 *           5
		 *         /  \        
		 *        1    4
		 *            / \         
		 *           3   6
		 * 
		 */
		
		/*
		TreeNode node_1 = new TreeNode(1);
		TreeNode node_6 = new TreeNode(6);
		TreeNode node_3 = new TreeNode(3);
		TreeNode node_4 = new TreeNode(4);
		TreeNode root = new TreeNode(5);
		root.setRightNode(node_4);
		root.setLeftNode(node_1);
		node_4.setRightNode(node_6);
		node_4.setLeftNode(node_3);
		*/
		
		/**
		 *           2
		 *         /  \        
		 *        2    2
		 */
		
		
		/*
		TreeNode root = new TreeNode(2);
		TreeNode node_1 = new TreeNode(2);
		TreeNode node_2 = new TreeNode(2);
		root.setRightNode(node_1);
		root.setLeftNode(node_2);
		*/
		
		/**
		 *         -2147483648
		 *              /          
		 *    -2147483648    
		 */
		
		/*
		TreeNode root = new TreeNode(-2147483648);
		root.setRightNode(root);
		root.setLeftNode(null);
		*/
		/*
		TreeNode root = new TreeNode(0);
		*/
		
		
		System.out.println(isValidBSTUsingInOrderTraversalIterative(root));
	}
	
	private static boolean isValidBSTRecursive(TreeNode root) {
		return isValidBSTInternal(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean isValidBSTInternal(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data >= max || root.data <= min) {
			return false;
		}
		
		return isValidBSTInternal(root.left,min,root.data) && isValidBSTInternal(root.right,root.data,max);
	}
	
	private List<Integer> list = new ArrayList<>();
	
	private void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			list.add(root.data);
			inOrder(root.right);
		}
	}
	
	private boolean isValidBSTUsingInOrderTraversalRecursive(TreeNode root) {
		inOrder(root);
        System.out.println(list);
		if(list.size() ==1) {
			return true;
		}
		if(containsDuplicates() || isUnOrderedSequence()) {
			return false;
		}
		return true;
	}
	
	private boolean containsDuplicates() {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			if(!hashSet.add(list.get(i)))
				return true;
		}
		return false;
	}
	
	private boolean isUnOrderedSequence() {
		for(int i=0;i<list.size();i++) {
			if(i == list.size()-1)
				break;
			
			if(list.get(i) > list.get(i+1))
				return true;
		}
		return false;	
	}

	private boolean isValidBSTUsingInOrderTraversalIterative(TreeNode root) {
		Stack<TreeNode> visited = new Stack<>();
		TreeNode current = root;
		visited.push(current);
		double left_child_value = -Double.MAX_VALUE;

		while (!visited.isEmpty()) {
			while (null != current) {
				current = current.left;
				visited.push(current);
			}
			current = visited.pop();

			if (null != current) {
				if (current.data <= left_child_value)
					return false;
				left_child_value = current.data;
			}
			if (null != current) {
				current = current.right;
				visited.push(current);
			}
		}
		return true;
	}
	
	private static void visitNode(final TreeNode node) {
		if (null != node)
			System.out.println(node); 
	}
	
}
