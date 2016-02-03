package PalindromePartitioning;

public class OptimizeSolution {
	public static int minCut(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int[] cut = new int[s.length()];
		for(int j = 0;  j < s.length(); j++) {
			cut[j] = j ;
			for(int i = 0; i <= j; i++) {
				if((s.charAt(i) == s.charAt(j) && j - i >= 2 && isPalindrome[i + 1][j - 1]) 
						|| (s.charAt(i) == s.charAt(j) && j - i < 2)){ 
					isPalindrome[i][j] = true;
					if(i == 0) {
						cut[j] = 0;
					} else {
						cut[j] = Math.min(cut[j], cut[i - 1] + 1);
					}
				}
			}
		}
		return cut[s.length() - 1];
	}
	
	public static void main(String[] args){
		System.out.println(minCut("aab"));
	}
}
