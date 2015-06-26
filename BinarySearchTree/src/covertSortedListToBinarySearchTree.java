import java.util.*;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
//联想中序遍历，此递归需要仔细考虑，时间复杂度O(n),空间复杂度O(logn)
public class covertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int size = 0;
		ListNode cur = head;
		ArrayList<ListNode> tem = new ArrayList<ListNode>();
		tem.add(head);
		while (cur.next != null) {
			cur = cur.next;
			size++;
		}
		return helper(head, 0, size, tem);
	}
	private TreeNode helper(ListNode head, int l, int r, ArrayList<ListNode> tem) {
		if (l < r)
			return null;
		int mid = (l+r)/2;
		TreeNode left = helper(head, l, mid-1, tem);
		TreeNode root = new TreeNode(tem.get(0).val);
		tem.set(0, tem.get(0).next);
		TreeNode right = helper(head, mid+1, r, tem);
		root.left = left;
		root.right = right;
		return root;
	}
}
