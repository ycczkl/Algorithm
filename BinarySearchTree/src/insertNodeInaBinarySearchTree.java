import java.util.*;

public class insertNodeInaBinarySearchTree {
	/**
	 * @param root
	 *            : The root of the binary search tree.
	 * @param node
	 *            : insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	// 二叉查找树的插入操作，原理跟二分查找类似。log(n)时间复杂度
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		if (node.val > root.val) {
			root.right = insertNode(root.right, node);
		} else if (node.val < root.val) {
			root.left = insertNode(root.left, node);
		} else {
			root = null;
		}
		return root;
	}

	// Non recursive
	public TreeNode insertNode2(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null) {
			if (cur.val > node.val) {
				pre = cur;
				cur = cur.left;
			} else if (cur.val < node.val) {
				pre = cur;
				cur = cur.right;
			} else
				return null;
		}
		if (pre.val > node.val)
			pre.left = node;
		else
			pre.right = node;
		return root;
	}

}
