import java.util.*;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class validateBinarySearchTree {
	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	// 中序遍历为递增序列则说明为BST
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		// handle the case that there may exit a node with Integer.MIN_VALUE;
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			if (root == null) {
				root = stack.pop();
				if (pre != null && root.val <= pre.val)
					return false;
				pre = root;
				root = root.right;
			} else {
				stack.push(root);
				root = root.left;
			}
		}
		return true;
	}

	// 递归版本的中序遍历，前驱节点可以用全局变量储存。
	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(null);
		return helper(root, list);
	}

	private boolean helper(TreeNode root, ArrayList<TreeNode> list) {
		if (root == null) {
			return true;
		}
		boolean left = helper(root.left, list);
		if (list.get(0) != null && root.val <= list.get(0).val) {
			return false;
		}
		list.set(0, root);
		boolean right = helper(root.right, list);
		return left && right;
	}

	// 递归思路与find maximum path相同，不过要考虑子节点是否为空的问题。
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean left = isValidBST2(root.left);
		boolean right = isValidBST2(root.right);
		if (!left || !right)
			return false;
		if (root.left == null && root.right == null) {
			return true;
		} else if (root.left != null && root.right != null) {
			return (root.val > root.left.val) && (root.val < root.right.val);
		} else {
			return root.left == null ? root.val < root.right.val
					: root.left.val < root.val;
		}

	}
}
