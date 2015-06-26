/*Given an sorted integer array - nums, and an integer - target.
 * Find the any/first/last position of target in nums, return -1 if target doesn’t exist.
 */
public class classicalBinarySearch {
	/* method1: Array without duplicate */
	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int s = 0;
		int e = nums.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target) {
				e = mid - 1;
			}
			if (nums[mid] < target) {
				s = mid + 1;
			}
		}
		return -1;
	}

	// method2: Array with duplicate
	public int binarySearchWithDuplicate(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int s = 0;
		int e = nums.length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (nums[mid] == target) {
				e = mid;
			} else if (nums[mid] > target) {
				e = mid;
			} else if (nums[mid] < target) {
				s = mid;
			}
		}
		if (nums[s] == target)
			return s;
		if (nums[e] == target)
			return e;
		return -1;
	}

	// Binary search for 2D array. 2维数组必须递增==》可展开成为1维数组
	public int binarySearchWithDuplicate2D(int[][] nums, int target) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			return -1;
		}		
		int cLen = nums[0].length;
		int s = 0;
		int e = nums.length * nums[0].length - 1;
		while (s + 1 < e) {
			int mid = (s + e) / 2;
			int value = nums[mid / cLen][mid % cLen];
			if (value == target) {
				e = mid;
			} else if (value > target) {
				e = mid;
			} else if (value < target) {
				s = mid;
			}
		}
		if (nums[s / cLen][s % cLen] == target)
			return s;
		if (nums[e / cLen][e % cLen] == target)
			return e;
		return -1;
	}
}