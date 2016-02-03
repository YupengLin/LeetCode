package WildcardMatching;

public class RegularExpressionMatch {
	public static boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;
		for(int i = 0; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				char curr = p.charAt(j - 1);
				if(curr != '*') {
					match[i][j] = (i > 0) && (match[i - 1][j - 1]) 
							&& (curr == '.' || curr == s.charAt(i - 1));
				} else {
					match[i][j] = (j > 1
							&& match[i][j - 2] )
							|| (i > 0 && match[i - 1][j] 
							&& ((p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.' )));
				}
			}
		}
		return match[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
	//	System.out.println(isMatch("aa", ".*"));
	//	int p = 0;
	//	System.out.println((( p = 3) < 0));
	}
}
