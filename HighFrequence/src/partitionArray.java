import java.util.*;

/*
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

 All elements < k are moved to the left
 All elements >= k are moved to the right

 Return the partitioning index, i.e the first index i nums[i] >= k.
 Example

 If nums=[3,2,2,1] and k=2, a valid answer is 1.
 Note

 You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

 If all elements in nums are smaller than k, then return nums.length
 Challenge

 Can you partition the array in-place and in O(n)?

 */
//类比pritition list, 用two pointer方法
public class partitionArray {
	/**
	 * @param nums
	 *            : The integer array you should partition
	 * @param k
	 *            : As description return: The index after partition
	 */
	//类比partition linked list, 链表单向扫，数组可以前后同时向中间扫。
	public int partitionArray(ArrayList<Integer> nums, int k) {
		if (nums == null || nums.size() == 0)
			return 0;
		int small = 0;		
		int large = nums.size()-1;
	    while (small <= large) {
			if (nums.get(small) >= k && nums.get(large) < k) {
				swap(nums, small, large);
			} else if (nums.get(small) < k) {
				small++;
			} else if (nums.get(large) >= k){
				large--;
			}
		}
	    return small;
	}

	private void swap(ArrayList<Integer> nums, int i, int j) {
		int tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
	}
}
