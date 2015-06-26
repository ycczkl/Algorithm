import java.util.*;

/*
 *  
Find the K closest points to the origin in 2D plane, given an array containing N points.
 You can assume K is much smaller than N and N is very large.
 */
public class FindTheKClosestPoints {
	public static Point[] findK(int k, Point[] arr) {
		Point[] res = new Point[k];
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return (p2.x*p2.x+p2.y*p2.y) - (p1.x*p1.x+p1.y*p1.y);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			Point p = arr[i];
			if (maxHeap.size() < k) {
				maxHeap.offer(p);				
			} else {
				Point top = maxHeap.peek();
				if ((top.x*top.x+top.y*top.y)-(p.x*p.x+p.y*p.y) > 0) {
					maxHeap.poll();
					maxHeap.offer(p);
				}
			}
		}
		int i = 0;
		while (!maxHeap.isEmpty()) {
			res[i++] = maxHeap.poll();
		}
		return res;
	}
	//Method2: quick select
	public static Point[] findK2(int k, Point[] arr) {
		Point[] res = new Point[k];
		helper(k-1, 0, arr.length-1, arr);
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	private static void helper(int k , int low, int high, Point[] arr) {
		int j = partition(low, high, arr);
		if (j == k)
			return;
		else if (j < k)
			helper(k, j+1, high, arr);
		else
			helper(k, low, j-1, arr);
	}
	private static int partition(int low, int high, Point[] arr) {
		int index = low + (int)((high-low+1)*Math.random());
		swap(arr, low, index);
		int l = low;
		int r = high+1;
		while (true) {
			while (distance(arr[++l]) <= distance(arr[low])) {
				if (l == high)
					break;
			}
			while (distance(arr[--r]) >= distance(arr[low])) {
				if (r == low)
					break;
			}
			if (l >= r)
				break;
			swap(arr, l, r);
		}
		swap(arr, low, r);
		return r;
	}
	private static void swap(Point[] arr, int i, int j) {
		Point tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private static double distance(Point p1) {
		return (p1.x*p1.x+p1.y*p1.y);
	}
	
	public static void main(String[] args) {
		Point[] arr = new Point[9];
		arr[0] = new Point(7,2);
		arr[1] = new Point(4,3);
		arr[2] = new Point(1,4);
		arr[3] = new Point(2,2);
		arr[4] = new Point(9,6);
		arr[5] = new Point(4,7);
		arr[6] = new Point(2,8);
		arr[7] = new Point(9,9);
		arr[8] = new Point(1,10);
		System.out.println(Arrays.toString(findK(5, arr)));
		
	}
	
}
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return this.x + " : "+this.y;
	}
}
