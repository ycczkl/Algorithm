/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Note

m and n will be at most 100.
 */

public class uniquePaths2 {
	/**
	 * @param obstacleGrid
	 *            : A list of lists of integers
	 * @return: An integer
	 */
	//递推式：if obstacleGrid[i][j] == 1, dp[i][j] = 0 else dp[i][j] = dp[i-1][j] + dp[i][j-1]
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1 || obstacleGrid == null
				|| obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int rLen = obstacleGrid.length;
		int cLen = obstacleGrid[0].length;
		int[][] dp = new int[rLen][cLen];
		dp[0][0] = 1;
		for (int i = 1; i < rLen; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			dp[i][0] = 1;
		}
		for (int i = 1; i < cLen; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			dp[0][i] = 1;
		}
		for (int i = 1; i < rLen; i++) {
			for (int j = 1; j < cLen; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[rLen - 1][cLen - 1];
	}
	
	//O(n) space
	//  注意corner case, 例如起点或终点为1的情况，初始化时有1的情况也要仔细考虑
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ||obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1)
                dp[0] = 0;
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}
