package ProductOfArrayExceptSelf;

public class Solution {
	 public static int[] productExceptSelf(int[] nums) {
		
		 
	    int[] product = new int[nums.length];      
	    product[0] = 1;
	    if(nums.length == 1) {
	    	return product;
	    }
	    for(int i = 1; i< nums.length; i++) {
	    	product[i] = product[i - 1] * nums[i - 1];
	    }
	    int postProduct = 1;
	    for(int i = nums.length - 1; i >= 0; i--) {
	    	product[i] = product[i] * postProduct;
	    	postProduct = postProduct * nums[i];
	    }
	    return product;
	  }
	 
	 public static void main(String[] args) {
		 int[] num = {1, 2, 3, 4};
		 int[] ans = productExceptSelf(num);
		 for(int i = 0; i< num.length; i++) {
		    	System.out.println(ans[i]);
		    }
	 }
}
