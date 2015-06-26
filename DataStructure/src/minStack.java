import java.util.*;

class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
    public void push(int x) {
    	if (stack.size() != 0) {
    		if (x <= minStack.peek())
    			minStack.push(x);
    	} else {
    		minStack.push(x);
    	}
        stack.push(x);
        
    }

    public void pop() {
        if (stack.size() > 0) {
        	int value = stack.pop();
        	if (value == getMin())
        		minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}