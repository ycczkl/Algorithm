/*
 * Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
//与find maximum类似，注意若左右节点有一个为空的时候深度不能为0，而是为不为空的那条边的深度加一。
public class minimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);		
		int right = minDepth(root.right);
		if (root.left == null || root.right == null) 
			return root.left == null ? right+1 : left+1;
		return Math.min(left, right)+1;
    }
}
