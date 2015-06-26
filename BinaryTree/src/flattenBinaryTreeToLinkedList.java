import java.util.*;
/*
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */

//Pre order traverse recursive
public class flattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if (root == null)
        	return;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.set(0, null);
        helper(root, list);
    }
	private void helper (TreeNode root, ArrayList<TreeNode> list) {
		if (root == null)
			return;
		TreeNode pre = list.get(0);
		TreeNode right = root.right;
		if (pre != null) {
			root.right = pre;
			root.left = null;
		}
		list.set(0, root);
		helper(root.left, list);
		helper(right, list);
	}
	
	//Iterate method
	public void flatten2(TreeNode root) {
		if (root == null)
			return;		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null) {
				root.right = root.left;
				root.left = null;
			} else if (!stack.isEmpty()){
				TreeNode cur = stack.pop();
				root.right = cur;				
			}
			root = root.right;
		}	
	}
}
