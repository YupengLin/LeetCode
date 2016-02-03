package RangeSumQueryImmutable;

public class NativeSolution {
	int[] nums;
	int[][] sums;
	
	public NativeSolution(int[] nums) {
		if(nums.length == 0 || nums == null) {
			return;
		}
		sums = new int[nums.length][nums.length];
			sums[0][0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			sums[i][i] = nums[i];
			sums[0][i] = sums[0][i - 1] + nums[i];
			//System.out.println("i = " + i + "sum = " + sums[0][i]);
		}
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				sums[i][j] = sums[i][j - 1] + nums[j]; 
			}
		}
		
	}
	
	public int sumRange(int i, int j){
		return sums[i][j];
	}
	
	public static void main(String[] args) {
		int[] nums = {};
		NativeSolution numArray = new NativeSolution(nums);
		System.out.println(numArray.sumRange(0, 5));
		
	}
}
