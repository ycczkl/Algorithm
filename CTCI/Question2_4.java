//Use two pointer in one linklist
public class Question2_4 {
	public static Node partition(Node n, int x) {
		Node head = n;
		Node tail = n;
		while (n != null) {
			Node next = n.next;
			if (n.data < x) {
				n.next = head;
				head = n;
			} else {
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		//the head has changed
		return head;
	}
	
	public static void main(String[] args) {		
		Node n = new Node(0);
		Node head = n;
		
		for(int i = 0; i < 20; i++) {
			Node end = new Node(i % 5);
			while (head.next != null) {
				head = head.next;
			}
			head.next = end;			
		}
		System.out.println(n.printLinkList());		
		System.out.println(partition(n, 3).printLinkList());
	}
}
