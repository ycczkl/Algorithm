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

//树的递归。两个节点可能在树的相同一边或者在树的两边。 递归时当找到一个节点时，返回该节点，递归从底向上过程中总会
//遇到left!=null, right!=null的情况，此时root为LCA，返回此root即可。
public class lowestCommanAncestor {
	/**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return root;
            
        if (root == A || root == B)
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null)
            return root;
            
        return left != null ? left : right;            
    }
    
}
