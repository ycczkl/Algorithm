/*
 * Reverse a linked list.

Example
For linked list 1->2->3, the reversed linked list is 3->2->1
 */

public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) 
        	return head;
        ListNode p1 = null;
        ListNode p2 = head;        
        while (p2 != null) {
        	ListNode tmp = p2.next;
        	p2.next = p1;
        	p1 = p2;
        	p2 = tmp;
        }
        return p1;
    }
	
	//Recusion method
	public ListNode reverseRecrusion(ListNode head) {
		if (head == null || head.next == null)
			return head;
		return helper(null, head);
	}
	private ListNode helper(ListNode pre, ListNode cur) {
		if (cur == null) {
			return pre;
		}
		ListNode head = helper(cur, cur.next);
		cur.next = pre;
		return head;
	}
}
