package WiggleSort;

import java.util.Arrays;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
       for(int i = 1; i < nums.length; i++) {
    	   if((i % 2 == 1 && nums[i] < nums[i - 1]) 
    		||(i % 2 == 0 && nums[i] > nums[i - 1])) {
    		   int temp = nums[i];
    		   nums[i] = nums[i - 1];
    		   nums[i - 1] = temp;
    	   }
       }
    }
	
	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int[] nums = {3, 5, 2, 1, 6, 4};
		ws.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
