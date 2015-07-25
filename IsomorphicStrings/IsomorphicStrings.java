package IsomorphicStrings;

import java.util.Hashtable;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		Hashtable<Character, Character> map = new Hashtable<Character, Character>();
		for(int i = 0; i < s.length(); i++) {
			Character cs = s.charAt(i);
			Character ct = t.charAt(i);
			
			if(map.containsKey(cs)) {
				Character corr = map.get(cs);
				if(!corr.equals(ct)) {
					return false;
				}
			} else {
				map.put(cs, ct);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
	}
}
