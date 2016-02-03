package ThreeSumCloset;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		int p1 = 0;
		int p2 = 1;
		int p3 = nums.length - 1;
		Arrays.sort(nums);
		int posDiff = Integer.MAX_VALUE;
		int negDiff = Integer.MAX_VALUE;
		for(p1 = 0; p1 < nums.length - 2; p1++) {
			p2 = p1 + 1;
			p3 = nums.length - 1;
			while(p2 < p3) {
				int tempSum = nums[p1] + nums[p2] + nums[p3];
				System.out.println("temp sum" + tempSum);
				if(tempSum > target ) {
					if(tempSum - target < posDiff){ posDiff = tempSum - target;}
					p3--;
				} else if(tempSum < target ) {
					if(target - tempSum < negDiff){ negDiff = target - tempSum;}
					p2++;
				} else  if(tempSum == target){
					return tempSum;
				}
			}
		}
		if(posDiff > negDiff) {
			return target - negDiff;
		} else {
			return target + posDiff;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 0};
		System.out.println(threeSumClosest(nums, 100));
	}
}
