/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
Example

Given an example [4,4,6,1,1,4,2,5], return 6.
Note

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class bestTimeToBuyAndSellStock3 {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
        	return 0;
        int[][] localMax = new int[prices.length][3];
        int[][] globalMax = new int[prices.length][3];
        for (int i = 1; i < prices.length; i++) {
        	int dif = prices[i] - prices[i-1];
        	for (int j = 1; j < 3; j++) {
        		localMax[i][j] = Math.max(globalMax[i-1][j-1] + Math.max(dif, 0), localMax[i-1][j]+dif);
        		globalMax[i][j] = Math.max(globalMax[i-1][j], localMax[i][j]);
        	}
        }
        return globalMax[prices.length-1][2];
    }
}
