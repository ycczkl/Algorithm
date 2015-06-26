/*
 * 描述：

在一个圆形操场的四周摆放着n堆石子(n<= 100)，现要将石子有次序地合并成一堆。规定每次只能选取相邻的两堆合并成新的一堆,并将新的一堆的石子数,记为该次合并的得分。

编一程序，读入石子堆数n及每堆的石子数(<=20)。选择一种合并石子的方案,使得做n－1次合并,得分的总和最小；

比如有4堆石子：4 4 5 9 则最佳合并方案如下：

4 4 5 9 score: 0
8 5 9 score: 8
13 9 score: 8 + 13 = 21
22 score: 8 + 13 + 22 = 43
 */

/*
 * 设dp[i][j]为从i到j的最小合并代价，要求的就是dp[1][n]。

可将(i,j)这个区间划分为(i , k) 和( k+1 ,j ) 两个区间合并而成，那么代价就为( i , j )这个区间的总的代价就为，dp[i][k]+dp[k+1][j]+sum[i][j]，sum[i][j]代表i到j石子的总代价。

那么dp[i][j] = min( dp[i][k]+dp[k+1][j] ) + sum[i][j]    { i<=k<j }

应为当计算i到j时，区间长度小于(i,j)的子区间必须被计算出来，那么递推顺序必须按照区间长度来枚举。
 */
public class stoneMerge {
	//dp[i][j] = Math.min(dp[i][k] + dp[k+1][j])+sum(i, j);
	public int minScore(int[] A) {
		if (A == null || A.length < 2)
			return 0;
		int[] sum = new int[A.length];		
		for (int i = 1; i < A.length+1; i++) {
			sum[i] += A[i];
		}
		int[][] dp = new int[A.length+1][A.length+1];
		for (int len = 2; len <= A.length; len++) {
			for (int i = 1; i <= A.length - len + 1; i++) {
				int j = i + len -1;
				int w = sum[j] - sum[i-1];
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.max(dp[i][k]+dp[k+1][j]+w, dp[i][j]);
				}
			}
		}
		return dp[1][A.length];
	}
}
