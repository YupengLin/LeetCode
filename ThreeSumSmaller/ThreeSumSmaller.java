package ThreeSumSmaller;

import java.util.Arrays;

public class ThreeSumSmaller {
	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		if(nums.length < 3) {
			return count;
		}
		int p1 = 0;
		int p2 = 0;
		int p3 = nums.length - 1;
		for(; p1 < nums.length - 2; p1++) {
			p2 = p1 + 1;
			p3 = nums.length - 1;
			while(p2 < p3) {
				int sum = nums[p1] + nums[p2] + nums[p3];
				if(sum >= target) {
					p3--;
				} else {
					count+= p3 - p2;
					p2++;
				}
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {-2, 0, 1, 3};
		System.out.println(threeSumSmaller(nums, 5));
	}
}
