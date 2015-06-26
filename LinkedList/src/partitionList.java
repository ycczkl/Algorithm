/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
//链表操作，可以设置两个dummy简化操作
public class partitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode smallDummy = new ListNode(0);
		ListNode largeDummy = new ListNode(0);
		ListNode small = smallDummy, large = largeDummy;
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}
		large.next = null;
		small.next = largeDummy.next;
		return smallDummy.next;
	}
}
