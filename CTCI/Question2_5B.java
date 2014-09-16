
public class Question2_5B {
	private static int length(Node l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}
	
	private static PartialSum addListHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		Node full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;	
	}
	
	private static Node addList(Node l1, Node l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1- len2);
		}
		PartialSum sum = addListHelper(l1, l2);
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	private static Node padList(Node l, int padding) {
		Node head = l;
		for (int i = 0; i < padding; i++) {
			Node n = new Node(0);
			head = insertBefore(head, n.data);			
		}
		return head;
	}
	
	
	
	private static Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if(list != null) {
			node.next = list;
		}
		return node;
	}
}

class PartialSum {
	public Node sum = null;
	carry = 0;
}
