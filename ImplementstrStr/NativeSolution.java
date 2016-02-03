package ImplementstrStr;

public class NativeSolution {
	
	public static int strStr(String hayStack, String needle){
		int len = needle.length();
		for(int i = 0; i <= hayStack.length() - len; i++) {
			String sub = hayStack.substring(i, i + len);
			if(sub.equals(needle)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] main) {
		String hayStack = "bbbbca";
		String needle = "ka";
		System.out.println(strStr(hayStack, needle));
		
	}
	

}
