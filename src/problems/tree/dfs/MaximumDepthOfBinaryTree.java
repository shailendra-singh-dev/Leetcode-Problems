package problems.tree.dfs;

import java.util.Stack;

import main.utilities.TreeNode;

/**
 * https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 */
public class MaximumDepthOfBinaryTree {

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
		System.out.println(maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) {
        return getDepth(root);        
    }
	
	/**
	 * Time Complexity: O(N).
	 * Space Complexity: O(1) Extra Space + O(H) Recursion Stack space, where “H”  is the height of the binary tree.
	 */
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
		return Math.max(1 + getDepth(root.left), 1 + getDepth(root.right)) ;
	}   
	
	public int getDepthV1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepthV1(root.left), getDepthV1(root.right)) + 1;
	}

	public int getDepthV2(TreeNode root) {
		if(root==null) return 0;
        
        int leftDepth=0;
        if(root.left!=null){
            leftDepth= getDepthV2(root.left);
        }
        
        int rightDepth=0;
        if(root.right!=null){
            rightDepth= getDepthV2(root.right);
        }
        return (Math.max(leftDepth, rightDepth)+1);
	}

}
