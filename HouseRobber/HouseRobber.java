package HouseRobber;



public class HouseRobber {
	 public static int rob(int[] nums) {
		 int[] maxIncome = new int[nums.length];
		 if(nums.length == 0) {
			 return 0;
		 }
		 if(nums.length == 1) {
			 return nums[0];
		 }
		 maxIncome[0] = nums[0];
		 maxIncome[1] = Math.max(nums[0], nums[1]);
		 if(nums.length > 2) {
			 for(int i = 2; i< nums.length; i++) {
				 for(int j = i-2; j >= 0; j--) {
					 maxIncome[i] = Math.max(maxIncome[i], maxIncome[j] + nums[i]);
				 }
				 maxIncome[i] = Math.max(maxIncome[i-1], maxIncome[i]);
				 System.out.println("max incom array" + maxIncome[i]);
			 }
		 }
	
		 return maxIncome[nums.length-1];
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = {2, 1, 1, 2};
		 System.out.println("rob = " + rob(nums));
	 }
}
