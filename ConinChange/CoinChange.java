package ConinChange;

import java.util.Arrays;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int[] change = new int[amount + 1];
		change[0] = 0;
		for(int i = 1; i <= amount; i++) {
			int minNum = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++) {
				if(i - coins[j] >= 0) {
					if(change[i - coins[j]] != -1) {
						minNum = Math.min(minNum, change[i - coins[j]] + 1);
					}
				}
			}
			//System.out.println(minNum);
			change[i] = (minNum == Integer.MAX_VALUE ? -1 : minNum);
		}
		
		return change[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = { 2, 5};
		System.out.println(coinChange(coins, 3));
	}
}
