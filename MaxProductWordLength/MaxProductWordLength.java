package MaxProductWordLength;

public class MaxProductWordLength {
	  public static int maxProduct(String[] words) {
		  	if(words.length == 0) {
		  		return 0;
		  	}
	        int[] masks = new int[words.length];
	        for(int i = 0; i < words.length; i++) {
	        	String currStr = words[i];
	        	int val = 0;
	        	for(int j = 0; j < currStr.length(); j++) {
	        		val |= 1 << (currStr.charAt(j) - 'a');
	        	}
	        	masks[i] = val;
	        }
	        
	        int max = 0;
	        for(int i = 0; i < words.length; i++) {
	        	for(int j = i + 1; j < words.length; j++) {
	        		if((masks[i] & masks[j]) == 0) {
	        			max = Math.max(max, words[i].length() * words[j].length());
	        		}
	        	}
	        }
	        return max;
	  }
	  
	  public static void main(String[] args) {
		  String[] test1 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		  System.out.println(maxProduct(test1));
		  String[] test2 = {"ab", "cd"};
		  System.out.println(maxProduct(test2));
	  }
}
