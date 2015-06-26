/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
*/

//同maximun depth of binary tree的递归一样。不过要注意在树不平衡时返回负值的技巧。 类比树的遍历，与此递归的异同。
public class balanceBinaryTree {
	public boolean isBalanced(TreeNode root) {
        return getHeight(root) > -1;
    }
    private int getHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }    
        int left = getHeight(n.left);
        int right = getHeight(n.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
