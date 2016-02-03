package MinimumSizeSubarraySum;

public class MinSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		while(end < nums.length) {
			while(sum < s  && end < nums.length)  {
				sum +=  nums[end++];
			}
			if(sum < s) break;
			while(sum >= s && start < end) {
				sum -= nums[start++];
			}
			if(end - start + 1 < minLen) minLen = end - start + 1;
			System.out.println("end " + end + "start " + start);
		}
		
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.println(minSubArrayLen(3, nums));
	}
	
	
}
