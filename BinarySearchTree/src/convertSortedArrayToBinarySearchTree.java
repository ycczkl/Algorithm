public class convertSortedArrayToBinarySearchTree {
	// Given an array where elements are sorted in ascending order, convert it
	// to a height balanced BST.
	//每次取数组中点即课构建平衡二叉搜索树。时间复杂度O(n), 空间复杂度log(n) + O(n)，递归求解。
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return helper(num, 0, num.length - 1);
	}

	private TreeNode helper(int[] num, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;		
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, left, mid - 1);
		root.right = helper(num, mid + 1, right);
		return root;
	}

}
