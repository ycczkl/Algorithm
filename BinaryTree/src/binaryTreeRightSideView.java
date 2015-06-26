/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
 */
import java.util.*;

//levelOrderTraverse的变形，每次取每层最右元素
public class binaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (root != null && queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				TreeNode n = queue.poll();
				if (i == 0)
					res.add(n.val);
				if (n.right != null)
					queue.offer(n.right);
				if (n.left != null)
					queue.offer(n.left);
			}
		}
		return res;
	}

}
