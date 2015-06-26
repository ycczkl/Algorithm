/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class removeDuplicatesfromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null) {
			while (head.next != null && head.next.val == head.val) {
				head = head.next;
			}
			if (pre.next == head) {
				pre = head;
			} else {
				pre.next = head.next;
			}
			head = head.next;			
		}		
		return dummy.next;
	}

}
