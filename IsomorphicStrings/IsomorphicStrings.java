package IsomorphicStrings;

import java.util.HashMap;
import java.util.Hashtable;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++) {
			Character cs = s.charAt(i);
			Character ct = t.charAt(i);
			
			if(map.containsKey(cs)) {
				Character corr = map.get(cs);
				if(!corr.equals(ct)) {
					return false;
				}
			} else {
				if(map.containsValue(ct)) return false;
				map.put(cs, ct);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		//System.out.println(isIsomorphic("egg", "add"));
		//System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("ab", "aa"));
	}
}
