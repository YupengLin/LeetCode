package WordLadder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLatter2 {
	private int minSize = Integer.MAX_VALUE;
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ladders = new ArrayList<>();
		List<String> sequence = new ArrayList<>();
		List<List<String>> shortestladders = new ArrayList<>();
		wordList.add(endWord);
		sequence.add(beginWord);
		dfs(ladders, sequence, endWord, beginWord, wordList);
		for(List<String> ladder : ladders) {
			if(ladder.size() == minSize) {
				shortestladders.add(new ArrayList<String>(ladder));
			}
		}
		return shortestladders;
	}
	
	public void dfs(List<List<String>> ladders, List<String> sequence,  String endWord, String currWord, Set<String> wordList) {
		if(currWord.equals(endWord)){
			System.out.println("hit");
			minSize = Math.min(minSize, sequence.size());
			ladders.add(new ArrayList<String>(sequence));
			return;
		}
		
		for(String word : wordList) {
			if(validTransfer(currWord, word)) {
				if(!sequence.contains(word)) {
					sequence.add(word);
					dfs(ladders, sequence, endWord, word, wordList);
					sequence.remove(sequence.size() - 1);
				}
			}
		}
	}
	
	private boolean validTransfer(String old, String transfer) {
		int transferCount = 0;
		for(int i = 0; i < old.length(); i++) {
			if(old.charAt(i) != transfer.charAt(i)) {
				transferCount++;
				if(transferCount >= 2) 
					return false;
			}
		}
		return transferCount == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		WordLatter2 wl = new WordLatter2();
		
		String[] words = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar",
				"ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or",
				"rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh",
				"co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la",
				"st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		Set<String> dict = new HashSet<String>(Arrays.asList(words));
		List<List<String>> ladders = wl.findLadders("qa", "sq", dict);
		System.out.println(wl.validTransfer("log", "dot"));
		for(List<String> seg : ladders) {
			System.out.println(seg);
		}
		
	}

}
