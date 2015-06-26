import java.util.*;

/*
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Example
For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.

          20

       /       \

    8           22

  /     \

4       12
 */
public class searchRangeInBinarySearchTree {
	//递归解，相当于求范围在k1,k2之间的BST中序遍历结果。 非递归解可以用栈进行中序遍历。
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		helper(root, k1, k2, res);
		return res;
    }
	private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
		if (root == null)
			return;
		if (root.val > k1) {
			helper(root.left, k1, k2, res);
		}
		if (root.val >= k1 && root.val <= k2)
			res.add(root.val);
		if (root.val < k2) {
			helper(root.right, k1, k2, res);
		}
	}
}
