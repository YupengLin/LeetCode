package WordBreak;

import java.util.*;

public class WordBreaker2 {
	public List<String> wordBreak(String s, Set<String> dict){
		
		ArrayList<ArrayList<Integer>> record=new ArrayList<ArrayList<Integer>>(s.length());
		for(int i=0;i<s.length();i++){
			record.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<s.length();i++){
			for(int j=i;j<s.length();j++){
				String word=s.substring(i,j+1);
				if(dict.contains(word)){
					record.get(i).add(j+1);
				}
			}
		}
		
		ArrayList<String> sentences=new ArrayList<String>();
		
		buildSolution(s,record,0,"",sentences);
		return sentences;
	}
	
	private void buildSolution(String s,ArrayList<ArrayList<Integer>> record,int current, String sentence,ArrayList<String> sentences){
	  
		if(current==s.length()){
			return;
		}
		
		for(int end : record.get(current)){
			String part=s.substring(current,end);
			sentence=sentence+(sentence==null ? part : " "+part);
			//if(current==s.length()){
				if(end==s.length()){
					sentences.add(sentence);
			}
		     buildSolution(s,record,end,sentence,sentences);
			
			
		}
		
		
	}
	public static void main(String[] args){
		WordBreaker2 test=new WordBreaker2();
		String s="catsanddog";
		Set<String> dict=new HashSet<String>();
		dict.add("cat");
		dict.add("and");
		dict.add("dog");
		dict.add("cats");
		dict.add("sand");
		
		List<String> ans=test.wordBreak(s,dict);
		for(String sen:ans){
			System.out.println(sen);
		}
	}
	
   

}
