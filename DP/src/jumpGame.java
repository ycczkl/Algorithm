/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
Example

A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

 */
public class jumpGame {
	/**
	 * @param A
	 *            : A list of integers
	 * @return: The boolean answer
	 */
	// dp[i-1] = Math.max(dp[i]-1, A[i]).
	//此题的state的含义是在下标i的地址能jump得最远距离。 如果为0则return false;
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0)
			return false;
		int[] dp = new int[A.length];
		dp[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = Math.max(dp[i - 1] - 1, A[i]);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean canJump2(int[] A) {
		if (A == null || A.length == 0)
			return false;
		int dp = A[0];
		for (int i = 1; i < A.length; i++) {
			if (dp > 0) {
				dp = Math.max(dp - 1, A[i]);
			} else {
				return false;
			}
		}
		return true;
	}
	
	//全局最优解
	public boolean canJump3(int[] A) {
		if (A == null || A.length == 0)
			return false;
		int reach = 0;
		for (int i = 0; i <=reach && i < A.length; i++) {
			reach = Math.max(A[i] + i, reach);
		}
		if (reach < A.length-1)
			return false;
		return true;
	}
}
