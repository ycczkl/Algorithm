import java.util.*;

//non recrusion Both O(n)
public class maximunDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}

			}
			level++;
		}
		return level;
	}
//recrusion Both O(n)
	public int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth2(root.left);
		int right = maxDepth2(root.right);
		return Math.max(left, right) + 1;
	}
}
