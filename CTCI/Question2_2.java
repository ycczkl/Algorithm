// Use two pointer
public class Question2_2 {
	public static Node nthToLast(Node n, int k) {
		if (k < 0) {
			return null;
		}
		
		Node p1 = n;
		Node p2 = n;
		
		for (int i = 0; i < k; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		if (p2 == null) {
			return null;
		}
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Node n = new Node(0);
		Node first = n;
		for (int i = 0; i < 10; i++) {
			Node second = new Node( i % 3);
			first.next = second;
			first = second;
		}
		System.out.println(n.printLinkList());
		Node kth = nthToLast(n, 4);
		System.out.println(kth.printLinkList());
	}
}

class Node {
	public int data;
	Node next;
	
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
		Node n = this;
		if (n.next != null) {
			return n.data + " -> " + n.next.printLinkList();
		} else {
			return ((Integer)n.data).toString();
		}
	}
}
