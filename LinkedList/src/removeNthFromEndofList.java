/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
  Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.


Note:
Given n will always be valid.
Try to do this in one pass.
*/

public class removeNthFromEndofList {
	//faster, slower pointer
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode walker = dummy;
		ListNode runner = dummy;
		while (runner.next != null) {
			if (n <= 0) {
				walker = walker.next;
			}
			runner = runner.next;
			n--;
		}
		walker.next = walker.next.next;
		return dummy.next;
	}

}
