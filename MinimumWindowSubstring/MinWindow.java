package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;

public class MinWindow {
  public String minWindow(String S, String T){
	  HashMap<Character,Integer> count=new HashMap<Character,Integer>();
	  HashSet<Character> helper=new HashSet<Character>();
	  
	  
	  for(int i=0;i<S.length();i++){
		  char letter=S.charAt(i);
		  if(count.containsKey(letter)){
             int time=count.get(letter);
             time++;
             count.put(letter, time);
		  }else{
			  count.put(letter, 1);
		  }
	  }
	  
	  for(int j=0;j<T.length();j++){
		  char key=T.charAt(j);
	      if(!count.containsKey(key)){
	    	  return "";
	      }else{
	    	  helper.add(key);
	      }
	  
	  }
	  
	  int start=0;
	  int end=S.length()-1;
	  boolean startStop=false;
	  boolean endStop=false;;
	  while(start<end){
		  if(!startStop){
			  char character=S.charAt(start);
			  if(!helper.contains(character)){  
				  // s does not contains this letter advance
			      start++;
			      continue;
			  }else{
				  // s MINUS one
				  int time=count.get(character);
				  time--;
				  if(time==0){
					  startStop=true;
					  continue;
				  }else{
					  count.put(character, time);
					  start++;
					  continue;
				  }
				  
			  }// end of contains key
		  } //end of startStop
		  
		  
		  // from tail pointer
		  
		  
		  if(!endStop){
			  char character=S.charAt(end);
			  if(!helper.contains(character)){  
				  // s does not contains this letter advance
			      end--;
			      continue;
			  }else{
				  // s MINUS one
				  int time=count.get(character);
				  time--;
				  if(time==0){
					  endStop=true;
					  continue;
				  }else{
					  count.put(character, time);
					  end--;
					  continue;
				  }
				  
			  }// end of contains key
		  } //end of startStop
		  
		  if( startStop && endStop){
			  break;
		  }
		  
		  
		  
	  }
	  
	  return S.substring(start,end+1);
  }
  
  
  
  public String minWindow2(String S, String T) {
	
	        if (S == null || S.length() == 0 || T == null || T.length() == 0)
	            return "";
	        int m = T.length(), n = S.length();
	 
	        // Preprocessing: count the number of appearance of each unique character in T
	        HashMap<Character, Integer> stat = new HashMap<Character, Integer>();
	        for (int i = 0; i < m; i++) {
	            char c = T.charAt(i);
	            if (stat.containsKey(c))
	                stat.put(c, stat.get(c)+1);
	            else
	                stat.put(c, 1);
	        }
	 
	        int matches = 0;        // Current number of matches
	        int minimumBegin = -1, minimumEnd = n;  // Indices of the minimum window
	        int begin = 0, end = 0;     // Indices of the working window
	        for (; end < n; end++) {       // Move the right side of the working window
	            // Move end to the next position where S[end] appears in T
	            char endChar = S.charAt(end);
	            if (!stat.containsKey(endChar))     // Ignore characters not in T
	                continue;
	            // Update stat, and matches if necessary
	            stat.put(endChar, stat.get(endChar)-1); // Decrement the corresponding desired appearance
	            if (stat.get(endChar) >= 0)     // The current matched character is not redundant
	                matches++;
	            System.out.println(matches);
	            // S[begin...end] meets the requirement
	            while (matches == m) {
	                // Move begin to the next position where S[begin] appears in T
	                char beginChar = S.charAt(begin);
	                while (!stat.containsKey(beginChar))
	                    beginChar = S.charAt(++begin);
	                // Update stat
	                stat.put(beginChar, stat.get(beginChar)+1);
	                // S[begin+1...end] lacks a character same as S[begin]
	                // A possible minimum window is found
	                if (stat.get(beginChar) > 0) {
	                    if (end-begin < minimumEnd-minimumBegin) {
	                        minimumBegin = begin;
	                        minimumEnd = end;
	                    }
	                    matches--;
	                }
	                // Move the left side of the working window
	                begin++;
	            }
	        }
	 
	        if (minimumBegin >= 0)      // A minimum such window was found
	            return S.substring(minimumBegin, minimumEnd+1);
	        else        // No such window was found
	            return "";
         
 }
  public static void main(String[] args){
	  MinWindow mw=new MinWindow();
	  String s="AAAAADOBECODEBANC";
	  String t="ABC";
	  System.out.println(mw.minWindow2(s, t));
  }
}


