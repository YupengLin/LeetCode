package MajorityElement2;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public static List<Integer> majorityElement(int[] nums) {
		  int candidate1 = 0;
			int candidate2 = 0;
			int counter1 = 0;
			int counter2 = 0;
			boolean secondMajor = false;
			List<Integer> major = new ArrayList<Integer>();
			
			for(int i = 0; i < nums.length; i++) {
				if(counter1 == 0) {
					candidate1 = nums[i];
					counter1 = 1;
				}  else if(candidate1 == nums[i]) {
					counter1++;
			}  else if (counter2 == 0) {
					secondMajor = true;
					candidate2 = nums[i];
					counter2 = 1;
				}else if(candidate2 == nums[i]) {
						counter2++;
					} else {
						counter1--;
						counter2--;
					}
		   }
			
			counter1 = 0;
			counter2 = 0;
			
			for(int i=0; i<nums.length; i++) {
				if(nums[i] == candidate1) {
					counter1++;
				}
				if((candidate1 != candidate2 ) && nums[i] == candidate2) {
					counter2++;
				}
			}
			
			if(counter1 > nums.length / 3) {
				major.add(new Integer(candidate1));
			}
			if(counter2 > nums.length / 3 && secondMajor) {
				major.add(new Integer(candidate2));
			}
			
			return major;
	}

	
	public static int boyerMajorityElement(int[] nums) {
		int candidate = nums[0];
		int counter = 0;
		
		for(int i = 0; i<nums.length; i++) {
			if(counter == 0) {
				candidate = nums[i];
				counter = 1;
			} else {
				if(candidate == nums[i]) {
					counter++;
				} else {
					counter--;
				}
			}
		}		
		counter = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == candidate) {
				counter++;
			}
		}
		
		if(counter < (nums.length + 1) / 2) {
			return -1;
		} else {
			return candidate;
		}
	}
	

	
	public static void main(String[] args) {
		int[] test = {0, -1, 2, -1};
		System.out.println(majorityElement(test).toString());
	}
}
