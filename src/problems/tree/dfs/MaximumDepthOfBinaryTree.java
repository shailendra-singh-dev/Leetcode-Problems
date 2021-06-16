package problems.tree.dfs;

import java.util.Stack;

import main.utilities.TreeNode;

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
