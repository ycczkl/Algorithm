import java.util.*;

public class binaryTreePreorderTraversal {
	//Non recursion
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();		
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return res;
	}
	
	//Traverse
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return res;
		traverse(root, res);
		return res;
	}
	private  void traverse(TreeNode n, List<Integer> res) {
		if (n == null)
			return;
		res.add(n.val);
		traverse(n.left, res);
		traverse(n.right, res);
	}
}
