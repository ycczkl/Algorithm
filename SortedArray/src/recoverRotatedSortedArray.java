import java.util.Arrays;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 * 
 * Example [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * 
 * Challenge In-place, O(1) extra space and O(n) time.
 */
// 翻转有序数组的恢复。 O(n)时间， O(1)空间。 用同样的方法可以实现有序数组的翻转
public class recoverRotatedSortedArray {
	public static void recoverRotatedSortedArray(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i-1]) {
				reverse(nums, 0, i-1);
				reverse(nums, i, nums.length-1);
				reverse(nums, 0, nums.length-1);
				return;
			}
		}
	}
	private static void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++,j--) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] a = {2,3,4,4,4,4,1,2,2,2,2};
		recoverRotatedSortedArray(a);
		System.out.println(Arrays.toString(a));
	}
}
