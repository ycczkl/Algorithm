/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]


The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class houseRobber {
	// 递推式：dp[i] = (dp[i-2] + num[i],dp[i-1])
	public int rob(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		if (num.length < 3) {
			if (num.length == 1)
				return num[0];
			else
				return Math.max(num[0], num[1]);
		}
		int[] dp = new int[num.length];
		dp[0] = num[0];
		dp[1] = Math.max(num[0], num[1]);
		for (int i = 2; i < num.length; i++) {
			dp[i] = Math.max(dp[i - 2] + num[i], dp[i - 1]);
		}
		return dp[dp.length - 1];
	}
}
