package MissingNumber;

public class MissingNumber {
	  public static int missingNumber(int[] nums) {
	        int len = nums.length;
	        int sum = (0 + len) * (len + 1) / 2;
	        for(int i = 0; i < len; i++) {
	        	sum = sum - nums[i];
	        }
	        return sum;
	    }
	  
	  public static void main(String[] args) {
		  int [] input= {3, 1, 2};
		  System.out.println(missingNumber(input));
	  }
}
