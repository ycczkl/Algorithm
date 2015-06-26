/*
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 */
//dp[i] = Math.max(A[i], A[i]+dp[i-1]), return max value in dp array
//运用全局和局部最优解思路
public class maximumSubarray {
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
        	return 0;
        int local = A[0];
        int global = A[0];
        for (int i = 1; i < A.length; i++) {
        	local = Math.max(A[i], A[i]+local);
        	global = Math.max(global, local);
        }
        return global;
    }
}
