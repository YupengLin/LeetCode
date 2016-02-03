package ShortestWordDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {
	private HashMap<String, List<Integer>> wordLocation;
	
	public ShortestWordDistance2(String[] words) {
		wordLocation = new HashMap<String, List<Integer>>();
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			if(wordLocation.containsKey(word)) {
				List<Integer> indices = wordLocation.get(word);
				indices.add(i);
				wordLocation.put(word, indices);
			} else {
				List<Integer> indices = new ArrayList<Integer>();
				indices.add(i);
				wordLocation.put(word, indices);
			}
		}
	}
	
	public int shortest(String word1, String word2) {
		int minDistance = Integer.MAX_VALUE;
		List<Integer> idxWord1 = wordLocation.get(word1);
		List<Integer> idxWord2 = wordLocation.get(word2);
		for(int i = 0, j = 0; i < idxWord1.size() && j < idxWord2.size(); ) {
			int idx1 = idxWord1.get(i);
			int idx2 = idxWord2.get(j);
			if(idx1 > idx2) {
				minDistance = Math.min(minDistance, idx1 - idx2);
				j++;
			} else {
				minDistance = Math.min(minDistance, idx2 - idx1);
				i++;
			}
		}
		return minDistance;
	}
	
	public static void main(String[] args) {
		String[] words = {"a", "c", "b", "a"};
		ShortestWordDistance2 wd2 = new ShortestWordDistance2(words);
		System.out.println(wd2.shortest("a", "b"));
		
	}
}
