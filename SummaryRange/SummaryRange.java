package SummaryRange;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
	public static List<String> summaryRange(int[] nums) {
		List<String> summary = new ArrayList<String>();
		if(nums.length == 0) {
			return summary;
		}
		int start = nums[0];
		int end = nums[0];
		int distance = 1;
		
		if(nums.length == 1) {
			summary.add(new Integer(start).toString());
			return summary;
		}
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] - start == distance) {
				end = nums[i];
				distance++;
				if(i == nums.length - 1) {
					String range = new Integer(start).toString();
					range = range + "->";
					range = range + new Integer(end).toString();
					summary.add(range);
				}
			} else {
				if(start == end) {
					summary.add(new Integer(start).toString());
				} else {
					String range = new Integer(start).toString();
					range = range + "->";
					range = range + new Integer(end).toString();
					summary.add(range);
				}
					start = nums[i];
					end = nums[i];
					distance = 1;
					if(i == nums.length - 1) {
						summary.add(new Integer(start).toString());
					}
				
			}
		}
		return summary;
	}
	
	public static void main(String[] args) {
		int[] nums ={1,3};
		
		List<String> ans = summaryRange(nums);
		System.out.println(ans.toString());
	}
}
