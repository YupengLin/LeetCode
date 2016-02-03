package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class NaticeSolution {
	public static int longestConsecutive(int[] nums) {
		Set<Integer> numbers = new HashSet<>();
		int maxSeq = 0;
		for(int num : nums) {
			numbers.add(num);
		}
		
		for(int num : nums) {
			if(numbers.remove(num)) {
				int length = 1;
				int left = num - 1;
				while(numbers.remove(left)) {
					left--;
				}
				length += num - left - 1;
				int right = num + 1;
				while(numbers.remove(right)){
					right++;
				}
				length += right - num - 1;
				maxSeq = Math.max(length, maxSeq);
			}
		}
		return maxSeq;
	}
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 3, 4, 2, 1};
		System.out.println(longestConsecutive(nums));
	}
}
