package BestTimeToBytAndSellStoack3;

public class DPSolution {
	public int maxProfit(int k, int[] prices) {
		int[][] profits = new int[k + 1][prices.length];
		if(k > prices.length/2) {
			int profit = 0;
			for(int i = 1; i < prices.length; i++) {
				if(prices[i] > prices[i - 1]) {
					profit += prices[i] - prices[i - 1];
				}
			}
			return profit;
		}
		
		for(int i = 1; i <= k; i++) {
			int localMax = profits[i - 1][0] - prices[0];
			for(int j = 1; j < prices.length; j++) {
				profits[i][j] = Math.max(profits[i - 1][j], localMax + prices[j] );
				localMax= Math.max(localMax, profits[i - 1][j] - prices[j] );
			}
		}
		
		return profits[k][prices.length - 1];
	}
}
