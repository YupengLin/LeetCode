package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ThreeSum.ThreeSum;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		int p1 = 0;
		int p2 = 1;
		int p3 = 2;
		int p4 = nums.length;
		List<List<Integer>> fourSums = new ArrayList<>();
		
		for(p1 = 0; p1 < nums.length - 3; p1++) {
			for(p2 = p1 + 1; p2 < nums.length - 2; p2++) {
				p3 = p2 + 1;
				p4 = nums.length - 1;
				int partSum = nums[p1] + nums[p2];
				while(p3 < p4) {
					int result = partSum + nums[p3] + nums[p4];
					if( result == target) {
						List<Integer> sum = new ArrayList<>();
						sum.add(nums[p1]);sum.add(nums[p2]);
						sum.add(nums[p3]);sum.add(nums[p4]);
						
						while(p3 < p4 && nums[p3] == nums[p3 + 1]) p3++;
						while(p3 < p4 && nums[p4] == nums[p4 - 1]) p4--;
					
						if(!fourSums.contains(sum)) fourSums.add(sum);
						p3++;
						p4--;
						
					} else if (result < target) {
						p3++;
					} else {
						p4--;
					}
				}
			}
		}
		
		return fourSums;
	}
	
	public static void main(String[] args) {
		
		int[] nums={1, 0, -1, 0, -2, 2};
		
		
		List<List<Integer>> ans=fourSum(nums, 0);
		
		for (List<Integer> single :ans){
			System.out.println(single.toString());
		}
	}
	
	
	
}
