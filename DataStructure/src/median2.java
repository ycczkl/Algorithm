import java.util.*;
/*
 * Numbers keep coming, return the median of numbers at every time a new number added.
Example

For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].
Challenge

Total run time in O(nlogn).
Clarification

What's the definition of Median? - Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

 */

public class median2 {
	public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int[] res = new int[nums.length];
        PriorityQueue<Integer> maxHeap =  new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        PriorityQueue<Integer> minHeap =  new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        maxHeap.offer(nums[0]);
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int median = maxHeap.peek();
            if (nums[i] <= median) {
                maxHeap.offer(nums[i]);
                if (maxHeap.size() - minHeap.size() == 2) {
                    minHeap.offer(maxHeap.poll());
                }
            } else {
                minHeap.offer(nums[i]);
                if (minHeap.size() - maxHeap.size() == 1) {
                    maxHeap.offer(minHeap.poll());
                }
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
