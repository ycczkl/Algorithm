import java.util.ArrayList;


public class Question3_3 {
	class setOfStacks {
		ArrayList<LinkStack> stacks = new ArrayList<LinkStack>();
		private int capacity;
		public void push(int value) throws Exception {
			LinkStack<Integer> stack = getLastStack();
			if (stack.size >= capacity) {
				LinkStack<Integer> newStack = new LinkStack<Integer>();
				newStack.push(value);
				stacks.add(newStack);
			} else {
				stack.push(value);
			}
		}
		
		public int pop() throws Exception {
			LinkStack<Integer> stack = getLastStack();
			int value = stack.pop();
			if ((stack.size - 1) == 0) {				
				stacks.remove(stacks.size() - 1);
				return value;
			} else {
				return value;
			}
		}
		
		public LinkStack<Integer> getLastStack() throws Exception {
			if (stacks.size() == 0) {
				throw new Exception("Stack is empty");
			}
			return stacks.get(stacks.size() - 1);
		}
		
		public int popAt(int index) throws Exception {
			if (index < 0 || index > stacks.size()) {
				throw new Exception("Wrong index number");
			}
			LinkStack<Integer> stack = stacks.get(index);
			return stack.pop();
		}
	}
}
