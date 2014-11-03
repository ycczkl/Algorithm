import java.util.LinkedList;
import java.util.Queue;


public class Question7_7 {
	public static void addToQueue(Queue<Integer> q, int v) {
		q.add(v * 3);
		q.add(v * 5);
		q.add(v * 7);
	}
	
	public static int getKthNumber(int k) {
		if (k < 0) {
			return 0;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		addToQueue(q, 1);
		int min = 0;
		for (int i = 0; i < k; i++) {
			min = q.peek();
			for (int a: q) {
				if (a < min) {
					min = a;
				}
			}
			//Delete all same value
			while (q.contains(min)) {
				q.remove(min);
			}
			
			addToQueue(q, min);
		}
		return min;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			System.out.println(i + " : " + getKthNumber(i));
		}
	}
}
