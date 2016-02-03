package CountSmallerNumberAfterSelf;

import java.util.ArrayList;
import java.util.List;

public class NativeSolution {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> collection = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			int smallerNum = 0;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[i]) {
					smallerNum++;
				}
			}
			collection.add(smallerNum);
		}
		return collection;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
		List<Integer> collection = new NativeSolution().countSmaller(nums);
		System.out.println(collection.toString());
	}
}
