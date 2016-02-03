package LongestIncreasingSubsequence;

public class LongestSubsequent {
	public static int lengthOfLIS(int[] nums) {
		int[] lenOfSeq = new int[nums.length];
		for(int i = 0; i < nums.length;i++) {
			lenOfSeq[i] = 1;
		}
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					int tempLen = lenOfSeq[j] + 1;
					if(tempLen > lenOfSeq[i]) {
						lenOfSeq[i] = tempLen;
					}
				}
			}
		}
		
		int max = 1;
		for(int i = 0; i < nums.length; i++) {
			if(lenOfSeq[i] > max) {
				max = lenOfSeq[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(nums));
	}

}
