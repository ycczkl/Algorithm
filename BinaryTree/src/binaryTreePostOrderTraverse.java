import java.util.*;

public class binaryTreePostOrderTraverse {
	//Non recrusion
	public List<Integer> postorderTraversal(TreeNode root) { 
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return res;
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode peekNode = stack.peek();
				if (peekNode.right != null && pre != peekNode.right) {
					root = peekNode.right;
				} else {
					stack.pop();
					res.add(peekNode.val);
					pre = peekNode;
				}
			}
		}
		return res;
	}
	
	//Traverse
	public List<Integer> postorderTraversal2(TreeNode root) {
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
		traverse(n.left, res);
		traverse(n.right, res);
		res.add(n.val);
	}
}
