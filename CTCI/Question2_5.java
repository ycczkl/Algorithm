
public class Question2_5 {
//Q1
	public static Node addList(Node list1, Node list2, int carry) {
		if (list1 == null && list2 == null && carry == 0) {
			return null;
		}
		Node result = new Node();
		int value = carry;
		if (list1 != null) {
			value += list1.data; 
		}
		if (list2 != null) {
			value += list2.data;
		}
		result.data = value % 10;
		if (list1 != null || list2 != null) {
			Node more = addList(list1 == null ? null : list1.next,
								list2 == null ? null : list2.next,
								value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Node list1 = new Node(0);
		Node list2 = new Node(10);
		for(int i = 0; i < 10; i ++) {
			Node n1 = new Node(i);
			Node l1 = list1;
			while(l1.next != null) {
				l1 = l1.next;
			}
			l1.next = n1;
		}
		for(int i = 10; i < 20; i ++) {
			Node n2 = new Node(i);
			Node l2 = list2;
			while(l2.next != null) {
				l2 = l2.next;
			}
			l2.next = n2;
		}
		System.out.println(list1.printLinkList());
		System.out.println(list2.printLinkList());
		System.out.println(addList(list1, list2, 0).printLinkList());
	}
}
