package WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	 public boolean wordBreak(String s, Set<String> dict) {
	        if(s==null ||s.length()==0){
	        	return true;
	        }
	        
	        boolean t[] = new boolean[s.length()+1];
	        t[0]=true;
	        for(int i=1;i<=s.length();i++){
	        	for(String toCompare:dict){
	        		int j=toCompare.length();
	        		if(j>i){
	        			continue;
	        		}else{
	        			String sub=s.substring(i-j,i);
	        			boolean compareResult=sub.equals(toCompare);
	        			t[i]=(t[i-j] && compareResult) || t[i];
	        			//t[i]=(t[i-j] && compareResult) ;
	        		}
	        	}
	        }
	        
	        return t[s.length()];
	    }
	 
	 
	 public List<String> wordBreak2(String s,Set<String> dict){
		 ArrayList<String> combo=new ArrayList<String>();
		 
		 
		 return combo;
	 }
	 
	 public static void main(String[]args){
		 String a="abcdefghijklmn";
		 System.out.println(a.substring(0, a.length()));
		 Set<String> dict=new HashSet<String>();
		 dict.add("leet");
		 dict.add("code");
		 dict.add("cat");
		 dict.add("and");
		 dict.add("dog");
		 Solution test1=new Solution();
		 System.out.println(test1.wordBreak("leetcode",dict));
		 System.out.println(test1.wordBreak("catanddog",dict));
	 }
}
