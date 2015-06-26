public class reverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int count = 1;
		while (count < n) {
			if (count == m - 1) {
				pre = head;
			}
			head = head.next;
			count++;
		}
		ListNode p = pre.next;
		ListNode q = head.next;
		reverse(pre.next, head);
		pre.next = head;
		p.next = q;
		return dummy.next;
	}

	private void reverse(ListNode n1, ListNode n2) {
		ListNode p1 = n1;
		ListNode p2 = n1.next;
		while (p2 != n2) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		p2.next = p1;
	}
	
	//polished code
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 1;
		while (pre.next != null && i < m) {
			pre = pre.next;
			i++;
		}
		if (i < m)
			return dummy.next;
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;		
		while (cur != null && i < n) {
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			mNode.next = next;
			cur = next;
			i++;
		}
		return dummy.next;
	}
}
