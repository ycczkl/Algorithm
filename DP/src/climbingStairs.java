/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example

Given an example n=3 , 1+1+1=2+1=1+2=3

return 3
 */
public class climbingStairs {
	/**
	 * @param n
	 *            : An integer
	 * @return: An integer
	 */

	// 递推：dp[i] = dp[i-1] + dp[i-2]
	public int climbStairs(int n) {
		// write your code here
		if (n <= 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
