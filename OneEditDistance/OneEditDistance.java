package OneEditDistance;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if(s.length() == t.length()) {
			return isOneModify(s,t);
		} else if(s.length() > t.length()) {
			return isOneInsert(s, t);
		} else {
			return isOneInsert(t, s);
		}
	}
	
	private boolean isOneModify(String s, String t) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) {
				count++;
				if(count >= 2) {
					return false;
				}
			}
		}
		return count == 1 ? true : false;
	}
	
	private boolean isOneInsert(String s, String t) {
		int i = 0, j = 0;
		for(i = 0, j = 0; i < s.length() && j < t.length(); i++, j++ ) {
			if(s.charAt(i) != t.charAt(j)) {
				String sSub = s.substring(i + 1);
				String tSub = t.substring(j);
				return sSub.equals(tSub);
			}
		}
		return s.length() - t.length() == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		OneEditDistance oed = new OneEditDistance();
		System.out.println(oed.isOneEditDistance("a", ""));
	}
}
