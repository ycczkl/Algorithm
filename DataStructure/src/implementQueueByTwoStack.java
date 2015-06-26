import java.util.*;

public class implementQueueByTwoStack {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public implementQueueByTwoStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void push(int x) {
		stack1.push(x);
	}
	public int pop() {
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	public int top() {
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
