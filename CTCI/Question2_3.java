//can't delete the last node
public class Question2_3 {
	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		} else {
			n.data = n.next.data;
			n.next = n.next.next;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Node n = new Node(0);
		Node head = n;
		Node dn = head;
		for(int i = 0; i < 20; i++) {
			Node end = new Node(i % 5);
			while (head.next != null) {
				head = head.next;
			}
			head.next = end;
			if(i == 5) {
				dn = end;
			}
		}
		System.out.println(n.printLinkList());
		System.out.println(deleteNode(dn));
		System.out.println(n.printLinkList());
	}
}


