/*
 * Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)


 */
public class longestIncreasingSubsequence {
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
     
     // 3 2 7 2 8
     //state的含义是以第i个字符结尾的最长升序序列的长度
	 //State dp[i]: the length of LIS end with A[i]
     //if A[i] >= A[j], Math.max(dp[i],dp[j]+1) or 1	
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
