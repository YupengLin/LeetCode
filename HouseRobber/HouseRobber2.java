package HouseRobber;

public class HouseRobber2 {
	public int rob(int[] nums) {
		int[][] dp = new int[nums.length][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		dp[1][0] = nums[0];
		dp[1][1] = nums[1];
	}

}
