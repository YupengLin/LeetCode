package SubstringAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> index = new ArrayList<>();
		
		if(s.length() == 0 || words.length == 0) {
			return index;
		}
		
		HashMap<String, Integer> count = new HashMap<>();
		for(String word : words) {
			count.put(word, count.containsKey(word) ? count.get(word) + 1 : 1);
		}
		
		int len = words[0].length();
		int wordNum = words.length;
		
		for(int i = 0; i <= s.length() - len * wordNum; i++) {
			HashMap<String, Integer> copy = new HashMap<>(count);
			for(int j = 0; j < wordNum; j++) {
				String singleWord = s.substring(i + j*len, i + j*len + len);
				if(copy.containsKey(singleWord)) {
					int wordFreq = copy.get(singleWord);
					if(wordFreq == 1) {
						copy.remove(singleWord);
					} else {
						copy.put(singleWord, wordFreq - 1);
					}
					if(copy.isEmpty()) {
						index.add(i);
						break;
					}
				} else {
					// does not contain word in list
					break;
				}
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Solution findAll = new Solution();
		String target = "wordgoodgoodgoodbestword";
		String[] list = {"word", "good", "best", "good"};
		
		System.out.println(findAll.findSubstring(target, list));
	}
	
	

}
