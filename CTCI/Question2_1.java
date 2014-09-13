import java.util.HashSet;

//Use buffer or not 
public class Question2_1 {
//use buffer. take O(n) time, O(n) space
	public void deleteDupsA(Node n) {
		if (n == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = null;
		while (n != null) {
			if (set.contains(n.data)) {
				pre.next = n.next;
			} else {
				set.add(n.data);
				pre = n;
			}
			n = n.next;
		}
		
	}
	
	public static void deleteDupsB(Node n) {
		if (n == null) {
			return;
		}
		
		Node current = n;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}				
			}
			current = current.next;
		}
		
	}
	
	public static void main(String[] args) {
		Node first = new Node(0);
		Node head = first;
		for (int i = 0; i < 8; i++) {
			Node second = new Node(i % 2);
			head.next = second;
			head = second;
		}
		System.out.println(first.printLinkList());
		deleteDupsB(first);
		System.out.println(first.printLinkList());
		
	}
}

class Node {
	public Node next;
	public int data;
	
	public Node(int d) {
		data = d;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public String printLinkList() {
		if (next != null) {
			return this.data + " -> " + next.printLinkList();
		} else {
			return ((Integer)this.data).toString();
		}
	}
	
}