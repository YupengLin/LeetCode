package StrobogrammaticNumber;

public class StrobogrammaticNumber {
	public static boolean isStrobogrammatic(String num) {
		if(num.length() == 0) {
			return true;
		}
		int start = 0;
		int end = num.length() - 1;
		while(start < end) {
			int startDigit = num.charAt(start) - '0';
			int endDigit = num.charAt(end) - '0';
			if((startDigit == 6 && endDigit == 9) 
			  ||(startDigit == 9 && endDigit == 6)
			  ||(startDigit == 8 && endDigit == 8)
			  ||(startDigit == 1 && endDigit == 1)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		if(num.length() % 2 == 0) {
			return true;
		} else {
			int midIdx = num.length() / 2;
			if(num.charAt(midIdx) == '1' 
				|| num.charAt(midIdx) == '8'
				|| num.charAt(midIdx) == '0')  {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("818"));
	}
}
