package GroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
	public static List<List<String>> groupAnagrams(String[] s) {
		List<List<String>> allAnagrams = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String word : s) {
			char[] singleChars = word.toCharArray();
			Arrays.sort(singleChars);
			String afterSortString = String.valueOf(singleChars);
			if(map.containsKey(afterSortString)) {
				map.get(afterSortString).add(word);
			} else {
				List<String> anagrams = new ArrayList<>();
				anagrams.add(word);
				map.put(afterSortString, anagrams);
			}
			
		}
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
		
	}
	
	public static void main(String[] args) {
		String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> anagrams = groupAnagrams(words);
		for (List<String> word  : anagrams) {
			System.out.println(word.toString());
		}
	}

}
