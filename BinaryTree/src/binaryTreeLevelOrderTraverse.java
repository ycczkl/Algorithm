import java.util.*;


public class binaryTreeLevelOrderTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}
				list.add(n.val);
			}
			res.add(list);
		}
		return res;
    }
	
}
