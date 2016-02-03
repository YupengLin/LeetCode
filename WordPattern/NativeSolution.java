package WordPattern;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class NativeSolution {
	public static  boolean wordPattern(String pattern, String str) {
		String[] word = str.split(" ");
		if(word.length != pattern.length()) {
			return false;
		}
		Hashtable<Character, String> freqTable = new Hashtable<>();
		for(int i = 0; i < pattern.length(); i++) {
			char letter = pattern.charAt(i);
			if(freqTable.containsKey(letter)) {
				if(!freqTable.get(letter).equals(word[i])) {
					return false;
				}
			} else {
				if(freqTable.containsValue(word[i])) {
					return false;
				}
				freqTable.put(letter, word[i]);
				
			}
		}
		return true;

	}
	
	
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}

}
