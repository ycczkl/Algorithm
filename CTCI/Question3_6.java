
public class Question3_6 {
	public static LinkStack<Integer> sort(LinkStack<Integer> stack) throws Exception {
		LinkStack<Integer> stackBuffer = new LinkStack<Integer>();
		while(!stack.isEmpty()){
			int data = stack.pop();
			while(!stackBuffer.isEmpty() && data < stackBuffer.peek()) {
				stack.push(stackBuffer.pop());
			}
			stackBuffer.push(data);
		}
		return stackBuffer;
	}
	
	public static void main(String[] args) throws Exception {
		LinkStack<Integer> stack = new LinkStack<Integer>();
		stack.push(3);
		stack.push(9);
		stack.push(6);
		stack.push(4);
		stack.push(3);
		LinkStack<Integer> sortStack = sort(stack);
		for(int i = 0; i < 5; i++) {
			System.out.println(sortStack.pop());
		}
	}
}
