package RangeSumQueryImmutable;

public class NumArray {
	int[] sums;
	
	public NumArray(int[] nums) {
		if(nums.length == 0) {
			return;
		}
		sums = new int[nums.length];
		sums[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
			System.out.println("sums = " + sums[i]);
		}
	}
	
	public int sumRange(int i, int j) {
		if(i == 0) {
			//System.out.println("i");
			return sums[j];
			
		} else {
			return sums[j] - sums[i - 1];
		}
	}
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(2, 5));
		
	}
}
