/*
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Example
        4

    /     \

  3         7

          /     \

        5         6

For 3 and 5, the LCA is 4.

For 5 and 6, the LCA is 7.

For 6 and 7, the LCA is 7.
 */
public class lowestCommanAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
        	return root;
        if (root == A || root == B)
        	return root;
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null)
        	return root;
        
        return left == null ? right : left;
    }
}
