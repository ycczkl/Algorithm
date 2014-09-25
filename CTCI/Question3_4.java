
public class Question3_4 {
	 class Tower {
		 LinkStack<Integer> stack;		 
		 
		 public Tower(int i) {
			 stack = new LinkStack<Integer>();			 
		 }
		 
		 public void add(int d) throws Exception{
			 if(d >= stack.peek()) {throw new Exception("Can't do this");} 
			 	else {
				 stack.push(d);
			 }	 
		 }
		 
		 public void moveTo(Tower destination) throws Exception {
			 int data = stack.pop();
			 destination.add(data);
		 }
		 
		 public void moveDisks(int n, Tower destination, Tower buffer) throws Exception {
			 moveDisks(n-1, buffer, destination);
			 moveTo(destination);
			 buffer.moveDisks(n-1,destination, this);
			 
		 }
	 }
	 
	 
}
