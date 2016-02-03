package MaximumGap;

import java.util.Arrays;

public class MaxGap {
	public static int maximumGap(int[] nums) {
		if(nums.length < 2) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		
		int minGap = (int) Math.ceil((double)(max - min) /( nums.length - 1));
		
		int[] minBucket = new int[nums.length - 1];
		int[] maxBucket = new int[nums.length - 1];
		
		Arrays.fill(minBucket, Integer.MAX_VALUE);
		Arrays.fill(maxBucket, Integer.MIN_VALUE);
		
		for(int num : nums) {
			if(num == max || num == min) continue;
			int index = (num - min) / minGap;
			minBucket[index] = Math.min(minBucket[index], num);
			maxBucket[index] = Math.max(maxBucket[index], num);
		}
		int prev = min;
		int maxGap = Integer.MIN_VALUE;
		for(int i = 0; i < minBucket.length; i++) {
			if(maxBucket[i] == Integer.MIN_VALUE && minBucket[i] == Integer.MAX_VALUE) continue;
			maxGap = Math.max(maxGap, minBucket[i] - prev);
			prev = maxBucket[i];
		}
		maxGap = Math.max(max - prev, maxGap);
		return maxGap;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 10000};
		System.out.println(maximumGap(nums));
	}
}
