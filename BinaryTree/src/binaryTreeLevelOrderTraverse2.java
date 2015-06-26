import java.util.*;
/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

	For example:
	Given binary tree {3,9,20,#,#,15,7}
	3
   / \
  9  20
    /  \
   15   7
	eturn its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class binaryTreeLevelOrderTraverse2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				if (n.left != null) {
					queue.offer(n.left);					
				}
				if (n.right != null) {
					queue.add(n.right);
				}
				list.add(n.val);
			}
			res.add(0, list);
		}
		return res;
	}
}
