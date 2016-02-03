package FindDuplicate;

import java.util.Arrays;

public class NativeSolution {
	public static int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		//if(nums.length =)
		int prev = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == prev)  {
				return prev;
			} else {
				prev = nums[i];
			}
		}
		
		return nums[nums.length - 1];
	}
	
	public static void main(String[] args) {
		int[] nums = {7,9,7,4,2,8,7,1,5};
		System.out.println(findDuplicate(nums));
	}
}
