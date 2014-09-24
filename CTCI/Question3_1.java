class LinkStack<T> {
	//First implement a link node
	private class Node {
		//Store data
		private T data;
		//Store the pointer
		private Node next;
		public Node() {
			
		}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//top element of a stack
	private Node top;
	public int size;
	public LinkStack() {
		top = null;
	}
	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}
	
	public int length() {
		return size;
	}
	
	public void push(T element) {
		top = new Node(element, top);
		size++;
	}
	
	public T pop() throws Exception{
		if (top != null) {
			Node element = top;
			top = top.next;
			element.next = null;
			size--;
			return element.data;
		}
		throw new Exception("Stack is empty");
	}
	
	public T peek() {
		return top.data;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}

public class Question3_1 {
	int stackSize = 100;
	int[] buffer = new int [stackSize * 3];
	int [] stackPointer = {-1, -1, -1};
	
	public void push(int stackNum, int element) throws Exception {
		if (stackPointer[stackNum] + 1 >= stackSize) {
			throw new Exception("out of space");
		} else {
			stackPointer[stackNum] ++;
			buffer[realLocation(stackNum)] = element;
		}
	}
	
	public int pop(int stackNum) throws Exception {		
		if (stackPointer[stackNum] - 1 < 0) {
			throw new Exception("Trying to pop an empty stack");
		} else {
			int top = realLocation(stackNum);
			int data = buffer[top];
			buffer[top] = 0;
			stackPointer[stackNum]--;
			return data;
		}
	}
	
	public int peek(int stackNum) {
		return buffer[realLocation(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] - 1 < 0;
	}
	
	public static void main(String[] args) {
		LinkStack stack = new LinkStack();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(stack.pop());
		}
	}
	
	private int realLocation(int stackNum) {
		int realNumber = stackNum * 100 + stackPointer[stackNum];
		return realNumber;
	}
}