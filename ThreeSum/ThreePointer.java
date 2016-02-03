package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreePointer {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> threeSums = new ArrayList<>();
		Arrays.sort(nums);
		if(nums.length <= 2) {
			return threeSums;
		}
		int p1 = 0;
		int p2 = 1;
		int p3 = 2;
		for(p1 = 0; p1 < nums.length - 2; p1++) {
			p2 = p1+1;
			p3 = nums.length - 1;
			while(p2 < p3) {
				if(nums[p1] + nums[p2] + nums[p3] == 0) {
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[p1]); result.add(nums[p2]); result.add(nums[p3]);
					while(p2 < p3 && nums[p2] == nums[p2+1]) p2++;
					while(p2 < p3 && nums[p3] == nums[p3-1]) p3--;
					if(!threeSums.contains(result)) threeSums.add(result);
					p2++;
					p3--;
				} else if (nums[p1] + nums[p2] + nums[p3] < 0) {
					p2++;
				} else if (nums[p1] + nums[p2] + nums[p3] > 0) {
					p3--;
				}
			}
		}
		return threeSums;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(nums);
		for(List<Integer> ans : result) {
			System.out.println(ans);
		}
	}
}
