
public class smaeTree {
	//从底向上递归 maximun depth的思路
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if (!left || !right)
            return false;
        return p.val == q.val;    
    }
	
	//从顶向下递归
	public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
        	return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
