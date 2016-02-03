package PalindromePartitioning;

public class PalindromePartition {
	public int minCut(String s) {
		int[] cut = new int[s.length() + 1];
		cut[0] = 0;
		cut[1] = 0;
		if(isPalindrome(s)) {
			return 0;
		}
		for(int i = 2; i <= s.length(); i++) {
			if(isPalindrome(s.substring(0, i))) {
				cut[i] = 0;
				continue;
			}
			int minCut = Integer.MAX_VALUE;
			for(int j = 1; j < i; j++) {
				if(isPalindrome(s.substring(j, i))) {
					int currCut = cut[i - j] + 1;
					minCut = Math.min(minCut, currCut);
					
				}
			}
			cut[i] = minCut;
		}
		
		return cut[s.length()];
	}
	
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartition pp2 = new PalindromePartition();
		//System.out.println(pp2.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		
	}
}
