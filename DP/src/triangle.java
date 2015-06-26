import java.util.*;
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

//Bottom up DP.
public class triangle {
	
	//O(n) space
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int[] dp = new int[triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
			dp[i] = triangle.get(triangle.size() - 1).get(i);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
	
	//Use O(n*n) space
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
			return 0;
		int n = triangle.size();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[n-1][i] = triangle.get(n - 1).get(i);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}
		return dp[0][0];
    }

}
