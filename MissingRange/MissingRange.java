package MissingRange;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> ranges = new ArrayList<String>();
		
		int currLow = lower;
		int currUp = lower;
		int expectNum = lower;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == expectNum) {
				expectNum++;
				currLow++;
			} else {
				int high = nums[i] - 1;
				if(currLow == high) {
					String missingRange = new Integer(high).toString();
					ranges.add(missingRange);
				} else {
					String  missingRange = new Integer(currLow ).toString();
					missingRange += "->";
					missingRange += new Integer(high).toString();
					ranges.add(missingRange);
				}
				expectNum = nums[i] + 1;
				currLow = nums[i] + 1;
			}	
		}
		int lastNum = nums[nums.length - 1];
		if( lastNum != upper) {
			String missingRange = new Integer(lastNum + 1).toString();
			if(lastNum + 1 != upper) {
				missingRange += "->" + new Integer(upper).toString();
			}
			ranges.add(missingRange);
		}
		return ranges;
	}
	
	public static void main(String[] args) {
		MissingRange mr = new MissingRange();
		int[] nums = {0};
		System.out.println(mr.findMissingRanges(nums, 0, 100));
	}
}
