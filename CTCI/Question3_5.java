
public class Question3_5 {
	class MyQueue<T> {
		private LinkStack<T> pushStack;
		private LinkStack<T> popStack;
		
		public MyQueue() {
			pushStack = new LinkStack<T>();
			popStack = new LinkStack<T>();
		}
		
		public void enqueue(T data) {
			pushStack.push(data);
		}
		
		public T dequeue() throws Exception {
			if (pushStack.isEmpty()) {
				if (popStack.isEmpty()) {
					return null;
				} else {
					return popStack.pop();
				}
			} else {
				if (popStack.isEmpty()) {
					while(!pushStack.isEmpty()) {
						popStack.push(pushStack.pop());
					}
				} 
				return popStack.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		Question3_5 outer = new Question3_5();
		MyQueue<Integer> test = outer.new MyQueue<Integer>(); 
		
		for (int i = 0; i < 10; i++)
			test.enqueue(i);			
		for (int i = 0; i < 5; i++)
			try {
				System.out.println(test.dequeue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int i = 10; i < 15; i++)
			test.enqueue(i);
		for (int i = 0; i < 10; i++)
			try {
				System.out.println(test.dequeue());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}
