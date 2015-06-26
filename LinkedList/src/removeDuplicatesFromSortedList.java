/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
//两个指针的应用
public class removeDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = head;
		ListNode runner = head.next;
		while (runner != null) {
			if (head.val == runner.val) {
				runner = runner.next;
			} else {
				head.next = runner;
				head = runner;
				runner = runner.next;
			}
		}
		head.next = null;
		return dummy;
	}

}
