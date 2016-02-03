package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] numbers = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			numbers[i] = new Integer(nums[i]).toString();
		}
		Arrays.sort(numbers, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String combo1 = s1 + s2;
				String combo2 = s2 + s1;
				return combo1.compareTo(combo2);
			}
		});
		
		if(numbers[numbers.length].equals("0")) return "0";
		
		StringBuilder largeNumber = new StringBuilder();
		for(int i = numbers.length - 1; i >= 0; i--) {
			largeNumber.append(numbers[i]);
		}
		
		return largeNumber.toString();
	}
	
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(ln.largestNumber(nums));
		
	}
	
	
	
	
}
