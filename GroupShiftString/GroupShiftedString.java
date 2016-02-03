package GroupShiftString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GroupShiftedString {
	public static List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String  s : strings) {
			String bitMap = getBitMap(s);
			if(map.containsKey(bitMap)) {
				List<String> sameString = map.get(bitMap);
				sameString.add(s);
				map.put(bitMap, sameString);
			} else {
				List<String> sameString = new ArrayList<String>();
				sameString.add(s);
				map.put(bitMap, sameString);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for(String key : map.keySet()) {
			List<String> sameStringList = map.get(key);
			Collections.sort(sameStringList);
			result.add(sameStringList);
		}
		return result;
		
	}
	
	private static String getBitMap(String s) {
		int[] bitMap = new int[s.length()];
		bitMap[0] = 0;
		for(int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c > s.charAt(0)) {
				bitMap[i] = c - s.charAt(0);
			} else {
				bitMap[i] = (c - s.charAt(0)) % 26;
			}
		}
		return Arrays.toString(bitMap);
		
	}
	public static void main(String[] args) {
		String[] shift = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		int[] test = {1, 2, 3, 4};
		System.out.println(Arrays.toString(test));
		
//		List<List<String>> ans = groupStrings(shift);
//		for(List<String> list : ans) {
//			System.out.println(list);
//		}
	}
}
