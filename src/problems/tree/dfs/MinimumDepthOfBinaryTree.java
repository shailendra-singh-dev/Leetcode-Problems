package problems.tree.dfs;

import main.utilities.TreeNode;

public class MinimumDepthOfBinaryTree {
	
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
