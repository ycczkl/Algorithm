import java.util.ArrayList;

/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
//节点可能有负值， 不一定最大值一定经过root。 递归的时候需要注意题目所求的路径最大值和返回值并不是同一个值。 路径最大值
//pathMax = root.val + Max(left, 0) + Max(right, 0); 返回值则是从根节点到子节点的最大值 returnVal = root.val + Max(left, right, 0); 
public class BinaryTreeMaximumPathSum {
	/**
	 * @param root
	 *            : The root of binary tree.
	 * @return: An integer.
	 */
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(Integer.MIN_VALUE);
		maxPath(root, res);
		return res.get(0);
	}

	public int maxPath(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return 0;
		}

		int left = maxPath(root.left, res);
		int right = maxPath(root.right, res);

		int curMax = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		if (curMax > res.get(0))
			res.set(0, curMax);
		return root.val + Math.max(left, Math.max(right, 0));
	}
}
