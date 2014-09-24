
public class Question3_2 {
	class StackWithMin extends LinkStack<Integer> {
		LinkStack<Integer> minStack;
		
		public StackWithMin() {
			minStack = new LinkStack();
		}
		
		public void push(int value) {
			if (value < min()) {
				minStack.push(value);
			}			
			super.push(value);
		}
		
		public Integer pop() throws Exception {			
			int value = super.pop();			
			if (value == min()) {
				minStack.pop();
			}
			return value;
		}
		
		public int min() {
			if (super.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return minStack.peek();
			}
		}
	}
}
