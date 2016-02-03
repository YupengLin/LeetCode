package ExcelSheetColumnNumber;

public class NativeSolution {
	public int titleToNumber(String s) {
		int number = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			number += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i -1);
			
		}
		return number;
	}
	
	public static void main(String[] args) {
		NativeSolution title = new NativeSolution();
		System.out.println(title.titleToNumber(""));
	}
}
