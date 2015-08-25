package ValidAnagram;

import java.util.Hashtable;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
	  if(s.length() != t.length()) {
		  return false;
	  }
      Hashtable<Character, Integer> s1 = new Hashtable<>();  
      Hashtable<Character, Integer> t1 = new Hashtable<>();
      
      for(int i = 0; i < s.length(); i++) {
    	  char k = s.charAt(i);
    	  if(s1.containsKey(k)) {
    		  int freq = s1.get(k);
    		  freq++;
    		  s1.put(k, freq);
    	  } else {
    		  s1.put(k, 1);
    	  }
      }
      
      for(int i = 0; i < t.length(); i++) {
    	  char k = t.charAt(i);
    	  if(t1.containsKey(k)) {
    		  int freq = t1.get(k);
    		  freq++;
    		  t1.put(k, freq);
    	  } else {
    		  t1.put(k, 1);
    	  }
      }
      
      for(int i = 0; i < s.length(); i++) {
    	  
    	  char k = s.charAt(i);
    	  int freq = s1.get(k); 
    	  if(!t1.containsKey(k) || t1.get(k) != freq) {
    		  
    		  return false;
    	  }
      }
      
      return true;
    }
	
	public static void main(String[] args) {
		//System.out.println(isAnagram("anagram", "nagarkm"));
		System.out.println(isAnagram("rat", "car"));
	}
}
