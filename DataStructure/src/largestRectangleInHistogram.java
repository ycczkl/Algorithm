import java.util.*;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example,
 Given height = [2,1,5,6,2,3],
 return 10.  
 */
//O(n) time and O(n) space
public class largestRectangleInHistogram {
	public static int largestRectangleArea(int[] height) {
		int globalMax = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= height.length; i++) {
			int cur = i == height.length ? -1 : height[i];
			while (!stack.isEmpty() && cur < height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				globalMax = Math.max(globalMax, h * w);
			}
			stack.push(i);
		}
		return globalMax;
	}

	// O(n*n*n)
	public static int largestRectangleArea2(int[] height) {
		int localMax = 0;
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j <= i; j++) {
				// pruning
				if (j != 0 && height[j] < height[j - 1])
					continue;
				int minHeight = Integer.MAX_VALUE;
				for (int k = j; k <= i; k++) {
					if (height[k] < minHeight)
						minHeight = height[k];
				}
				max = Math.max(max, minHeight * (i - j + 1));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(arr));
	}
}
