/*
 *  Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
 */
public class firstMissingPositive {
	//分析题目特点可联想到counting sort
	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
