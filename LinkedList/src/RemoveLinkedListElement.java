/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 */
public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            while (p.next != null && p.next.val == val)
                p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
	}
}
