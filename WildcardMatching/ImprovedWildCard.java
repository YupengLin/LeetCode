package WildcardMatching;

public class ImprovedWildCard {
	public static boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= p.length(); j++) {
				char curr = p.charAt(j - 1);
				if(curr != '*') {
					match[i][j] = (i > 0) && (match[i - 1][j - 1]) 
							&& (curr == s.charAt(i - 1) || curr == '?');
				} else {
					boolean flag = false;
					for(int k = 0; k <= i; k++) {
						if(match[k][j - 1]) {
							flag = true;
							break;
						}
						flag = flag || j == 1;
					}
					
					match[i][j] = flag;
				}
			}
		}
		
		return match[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
	}
}
