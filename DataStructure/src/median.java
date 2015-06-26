/*
 * 
 * Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.
Example

Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5
Challenge

O(n) time.

 */
public class median {

	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: An integer denotes the middle number of the array.
	 */
	//无需数组找第k小得数的特殊情况
	public int median(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int median = nums.length % 2 == 0 ? nums.length / 2 - 1
				: nums.length / 2;
		helper(nums, 0, nums.length - 1, median);
		return nums[median];
	}

	private void helper(int[] nums, int low, int high, int median) {
		if (low >= high)
			return;
		int j = partition(nums, low, high);
		if (j == median)
			return;
		if (j < median)
			helper(nums, j + 1, high, median);
		else
			helper(nums, low, j - 1, median);
	}

	private int partition(int[] nums, int low, int high) {
		int index = low + (int)Math.floor(Math.random() * (high - low + 1));
		swap(nums, low, index);
		int i = low;
		int j = high + 1;
		int v = nums[low];
		while (true) {
			while (nums[++i] <= v)
				if (i == high)
					break;
			while (nums[--j] >= v)
				if (j == low)
					break;
			if (j <= i)
				break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
