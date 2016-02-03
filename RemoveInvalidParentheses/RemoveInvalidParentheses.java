package RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> collection = new ArrayList<String>();
        int quotaOpen = maxOpen(s);
        int quotaClose = quotaOpen;
        StringBuilder sb = new StringBuilder();
        dfs(s.toCharArray(), collection, quotaOpen, quotaClose, 0, sb);
        return collection;
    }
	
	private void dfs(char[] letters, List<String> collection, int quotaOpen, int quotaClose, int currIndex, StringBuilder sb) {
		//System.out.println("quotaOpen = " + quotaOpen + "; quotaClose = " + quotaClose + " ;currIndex" + currIndex);
		if(quotaOpen > quotaClose || quotaOpen < 0 || quotaClose < 0) {
	
			return;
		}
		if(currIndex >= letters.length) {
			
			if(quotaOpen == 0 && quotaClose == 0) {	
			collection.add(sb.toString());
			}
			return;
		}
		
		char currChar = letters[currIndex];
		if(currChar != '(' && currChar != ')') {
			sb.append(currChar);
			dfs(letters, collection, quotaOpen, quotaClose, currIndex + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		} else if (currChar == '(') {
			int next = currIndex;
			
			
			while(next < letters.length && letters[next] == '(') {
				next++;	
			}
			
			for(int i = currIndex; i <= next; i++) {
				sb.append(letters, currIndex, i - currIndex);
				dfs(letters, collection, quotaOpen - (i - currIndex), quotaClose, next, sb);
				sb.delete(sb.length() - (i - currIndex), sb.length());
			}
		} else if (currChar == ')') {
			int next = currIndex;
			while(next < letters.length && letters[next] == ')') {
				next++;
			}
			
			for(int i = currIndex; i <= next; i++) {
				sb.append(letters, currIndex, i - currIndex);
				dfs(letters, collection, quotaOpen , quotaClose - (i - currIndex), next, sb);
				sb.delete(sb.length() - (i - currIndex), sb.length());
			}
		}
		
	}
	
	private int maxOpen(String s) {
		int openPair = 0;
		int parenthesesCount = 0;
		char[] letters = s.toCharArray();
		for(int i = 0; i < letters.length; i++) {
			if(letters[i] == '(') {
				parenthesesCount++;
			} else if(letters[i] == ')' && parenthesesCount > 0) {
				parenthesesCount--;
				openPair++;
			} else {
				
			}
		}
		
		return openPair;
	}
	
	public static void main(String[] args) {
		RemoveInvalidParentheses rm = new RemoveInvalidParentheses();
		String s = "((q)";
		System.out.println(rm.removeInvalidParentheses(s));
		
	}
}
