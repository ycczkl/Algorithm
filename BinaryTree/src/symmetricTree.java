import java.util.*;

/*
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3

 */
//对称递归，注意对null值的处理.时间复杂度O(n) 空间复杂度O(logn)
public class symmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);		
    }
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if ((left == null || right == null) || left.val != right.val)
			return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
	
//迭代，用两个queue进行比价
	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		queue1.offer(root.left);
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue2.offer(root.right);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode n1 = queue1.poll();
			TreeNode n2 = queue2.poll();
			if (n1 == null && n2 == null)
				continue;
			if ((n1 == null || n2 == null) || (n1.val != n2.val))
				return false;
			queue1.add(n1.left);
			queue1.add(n1.right);
			queue2.add(n2.right);
			queue2.add(n2.left);
		}
		return true;
	}
}
