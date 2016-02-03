package PalindromePermutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class PalindromePermutation {
	 public static boolean canPermutePalindrome(String s) {
		 HashMap<Character, Integer> charFreq = new HashMap<>();
		 char[] characters = s.toCharArray();
		 for(char c : characters) {
			 if(charFreq.containsKey(c)) {
				 int freq = charFreq.get(c);
				 freq++;
				 charFreq.put(c, freq);
			 } else {
				 charFreq.put(c, 1);
			 }
		 }
		 
		 int oddTimes = 0;
		 Iterator<Character> iter = charFreq.keySet().iterator();
		 while(iter.hasNext()) {
			 int charCount = charFreq.get(iter.next());
			 if(charCount % 2 != 0) {
				 oddTimes++;
				 if(oddTimes > 1) {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(canPermutePalindrome("carerac"));
	 }
}
