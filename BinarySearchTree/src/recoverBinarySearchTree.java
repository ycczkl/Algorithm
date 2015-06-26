import java.util.*;
/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/
//方法依然是inorder traverse递增的性质, 需要注意节点交换有两种情况:相邻节点交换和非相邻节点交换。例如: 12345, 
//相邻节点交换可能为12435,只需要交换43就可以还原。 非相邻接点交换的结果可能为12543，遍历会有两次不同，需要交换53
public class recoverBinarySearchTree {
	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(0, null);
		helper(root, list);
		TreeNode n1 = list.get(1);		
		TreeNode n2 = list.get(2);		
		int temp = list.get(1).val;
		n1.val = n2.val;
		n2.val = temp;
		return;
	}

	private static void helper(TreeNode root, ArrayList<TreeNode> list) {
		if (root == null)
			return;
		helper(root.left, list);
		TreeNode pre = list.get(0);
		if (pre != null && root.val < pre.val) {
			if (list.size() < 2) {
				list.add(pre);
				list.add(root);
			} else {
				list.set(2, root);
			}
		}
		list.set(0, root);
		helper(root.right, list);
	}
	public static void main (String[] args) {
		TreeNode n = new TreeNode(0);
		n.left = new TreeNode(1);
		recoverTree(n);
	}
}
