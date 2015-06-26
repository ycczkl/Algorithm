public class RemoveDuplicatesfromSortedArray {
	/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length. Do not allocate extra
	 * space for another array, you must do this in place with constant memory.
	 * For example, Given input array A = [1,1,2], Your function should return
	 * length = 2, and A is now [1,2].
	 */
	// Input: sorted array. Output: the length of new array and the array
	// without duplicate.
	// 除了统计重复外还要把非重复元素挪到数组左边。nums[res] = nums[i];
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[res] = nums[i];
				res++;
			}
		}
		return res;
	}
}
