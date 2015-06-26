import java.util.*;


public class binaryTreeInorderTraverse {
	//Non recursion
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					res.add(root.val);
					root = root.right;
				}
				
			}
			return res;
		}
		
	//traverse	
		public List<Integer> inorderTraversal2(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			traverse(root, res);
			return res;
		}
		private void traverse(TreeNode root, List<Integer> res) {
			if (root == null)
				return;
			traverse(root.left, res);
			res.add(root.val);
			traverse(root.right, res);
			
		}
}
