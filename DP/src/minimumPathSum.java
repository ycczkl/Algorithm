public class minimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int rLen = grid.length;
		int cLen = grid[0].length;
		int[][] dp = new int[rLen][cLen];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < rLen; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < cLen; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < rLen; i++) {
			for (int j = 1; j < cLen; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[rLen - 1][cLen - 1];
	}
	
	//O(n) space
	public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0)
                    dp[j] += grid[i][0];
                else if (i == 0) {
                    dp[j] = dp[j-1] + grid[0][j];
                }
                else
                    dp[j] = Math.min(dp[j], dp[j-1])+grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }
}
