package WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImprovedSolution {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> validWords = new ArrayList<String>();
		boolean t[] = new boolean[s.length()+1];
        t[0]=true;
        for(int i=1;i<=s.length();i++){
        	for(String toCompare:wordDict){
        		int j=toCompare.length();
        		if(j>i){
        			continue;
        		}else{
        			String sub=s.substring(i-j,i);
        			boolean compareResult=sub.equals(toCompare);
        			t[i]=(t[i-j] && compareResult) || t[i];
        		}
        	}
        }
        if(t[s.length()]) {
        	dfs(validWords, new StringBuilder(), 0, s, wordDict);
        }
		return validWords;
	}
	
	private static void dfs(List<String> validWords, StringBuilder stn, int curr, String s, Set<String> wordDict) {
		if(curr == s.length()) {
			validWords.add(new String(stn.toString()));
			return;
		}
		
		for(int i = curr + 1; i <= s.length(); i++) {
			String word = s.substring(curr, i);
			if(wordDict.contains(word)) {
				stn.append(" ").append(word);
				dfs(validWords, stn, i, s, wordDict);
				stn.setLength(stn.length() - 1 - word.length());
			}
		}
	}
	
	public static void main(String[] args) {
		String s="catsanddog";
		Set<String> dict=new HashSet<String>();
		dict.add("cat");
		dict.add("and");
		dict.add("dog");
		dict.add("cats");
		dict.add("sand");
		
		List<String> ans=wordBreak(s,dict);
		for(String sen:ans){
			System.out.println(sen);
		}
	}
}
