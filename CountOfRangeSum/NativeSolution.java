package CountOfRangeSum;

public class NativeSolution {
	public static int countRangeSum(int[] nums, int lower, int upper) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			int tempSum = nums[i];
			for(int j = i; j < nums.length; j++) {
				if(j != i) {
					tempSum += nums[j];
				}
				if(tempSum >= lower && tempSum <= upper) count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 5, -1};
		System.out.println(countRangeSum(nums, -2, 2));
	}
}
