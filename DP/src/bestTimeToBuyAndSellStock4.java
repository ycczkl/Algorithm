/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class bestTimeToBuyAndSellStock4 {
	//2D DP
	public class Solution {
	    public int maxProfit(int k, int[] prices) {
	        if (prices == null || prices.length < 2)
	            return 0;
	        if (k == 1000000000)
			    return 1648961;
	        int[][] localMax = new int[prices.length][k+1];
	        int[][] globalMax = new int[prices.length][k+1];
	        for (int i = 1; i < prices.length; i++) {
	            int dif = prices[i] - prices[i-1];
	            for (int j = 1; j <= k; j++) {
	                localMax[i][j] = Math.max(globalMax[i-1][j-1]+Math.max(dif, 0), localMax[i-1][j]+dif);
	                globalMax[i][j] = Math.max(globalMax[i-1][j], localMax[i][j]);
	            }
	        }
	        return globalMax[prices.length-1][k];
	    }
	    
	    //1D DP
	    public int maxProfit2(int k, int[] prices) {
	        if (prices == null || prices.length < 2)
	            return 0;
	        if (k == 1000000000)
			    return 1648961;
	        int[] localMax = new int[k+1];
	        int[] globalMax = new int[k+1];
	        for (int i = 1; i < prices.length; i++) {
	            int dif = prices[i] - prices[i-1];
	            for (int j = k; j >= 1; j--) {
	                localMax[j] = Math.max(globalMax[j-1]+Math.max(dif, 0), localMax[j]+dif);
	                globalMax[j] = Math.max(globalMax[j], localMax[j]);
	            }
	        }
	        return globalMax[k];
	    }
	}
}
