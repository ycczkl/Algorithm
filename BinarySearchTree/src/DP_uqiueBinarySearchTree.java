/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
// DP问题，找递推公式，dp[1] = 1, dp[n+1] = sum(dp[n-i]*dp[i]);
public class DP_uqiueBinarySearchTree {
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[i - j - 1] * dp[j];
			}
		}
		return dp[n];
	}
}
