package problems.tree;

import main.utilities.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 * 
 * @author ShSingh
 *
 */
public class ConvertSortedArrayToBST {

	public void test() {
		int[] a = { -10, -3, 0, 5, 9 };
		TreeNode treeNode = sortedArrayToBST(a);
		traversePreOrder(treeNode);
//		System.out.println();
//		traverseInOrder(treeNode);
//		System.out.println();
//		traversePostOrder(treeNode);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (null == nums || nums.length == 0)
			return null;
		return getMiddleNode(nums, 0, nums.length - 1);
	}

	public TreeNode getMiddleNode(int[] a, int start, int end) {
		if (a.length == 0 || a == null || start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(a[mid]);
		System.out.print(root);
		root.left = getMiddleNode(a, start, mid - 1);
		root.right = getMiddleNode(a, mid + 1, end);
		return root;
	}

	public void traversePreOrder(TreeNode node) {
		if (node != null) {
			visit(node);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traverseInOrder(TreeNode node) {
		if (node != null) {
			traverseInOrder(node.left);
			visit(node);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(TreeNode node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			visit(node);
		}
	}

	private void visit(TreeNode node) {
		System.out.print(node);
	}

}
