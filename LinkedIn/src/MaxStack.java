import java.util.*;
//Implement a stack with pop(), push(),  peek(), getMax(), popMax()
class Node {
	int value;
	public Node(int val) {
		this.value = val;
	}
}
//push: O(nlogn), pop(): O(n), peek(): O(1), getMax(): O(1), popMax(): O(n)
public class MaxStack {
	LinkedList<Node> list;
	PriorityQueue<Node> maxHeap;
	
	public MaxStack() {
		list = new LinkedList<Node>();
		maxHeap = new PriorityQueue<Node>(10, new Comparator<Node>(){
			public int compare(Node n1, Node n2) {
				return n2.value- n1.value;
			}
		});
	}
	
	public void push(int v) {
		Node n = new Node(v);
		maxHeap.offer(n);
		list.add(n);
	}
	
	public int peek() {
		return list.get(list.size()-1).value;
	}
	
	public int pop() {
		maxHeap.remove(list.get(list.size()-1));
		return list.remove(list.size()-1).value;
	}
	
	public int getMax() {
		return maxHeap.peek().value;
	}
	
	public int popMax() {
		list.removeLastOccurrence(maxHeap.peek());
		return maxHeap.poll().value;
	}
	public String toString() {
		String s = "";
		for (Node n : list) {
			s += "->"+n.value;
		}
		return s;
	}
	
	public static void main(String[] args) {
		MaxStack maxStack = new MaxStack();
		maxStack.push(1);
		maxStack.push(3);
		maxStack.push(4);
		maxStack.push(1);
		maxStack.push(9);
		maxStack.push(2);
		maxStack.push(4);
		maxStack.push(7);
		maxStack.push(6);
		maxStack.push(2);
		System.out.println(maxStack.toString());
		System.out.println(maxStack.peek());
		System.out.println(maxStack.getMax());
		System.out.println(maxStack.popMax());
		System.out.println(maxStack.getMax());
		System.out.println(maxStack.toString());
	}
}

