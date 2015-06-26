/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

public class sortList {
	//本质是merge sort, 可对比merge k sorted list的异同。 由于是在一个链表上进行操作，所以要先break再merge
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		ListNode left = head;
		ListNode right = walker.next;
		//First break the list, then merge together
		walker.next = null;
		left = sortList(left);
		right = sortList(right);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				head.next = left;
				left = left.next;
			} else {
				head.next = right;
				right = right.next;
			}
			head = head.next;
		}
		if (left != null) {
			head.next = left;
		} else {
			head.next = right;
		}
		return dummy.next;
	}
}
