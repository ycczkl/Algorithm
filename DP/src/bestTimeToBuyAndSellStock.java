/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class bestTimeToBuyAndSellStock {
	//一维动态规划，维护全局最大值和全局最小值。
	//global[i] = Max[global[i-1], local[i]];
	//local[i] = prices[i] - minimal;
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int localMax = prices[i] - min;
			max = Math.max(localMax, max);
			min = Math.min(prices[i], min);
		}
		return max;
    }
}
