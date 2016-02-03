package NumberDigitOne;

public class NumberOfDigitalOne {
	public  static int countDigitOne(int n) {
		int origin = n;
		int count = 0;
		int digitPosition = 1;
		while(n > 0) {
			int prev = n / 10;
			int targetDigit = n % 10;
			
			if(targetDigit == 0) {
				count = count + prev * digitPosition;
			} else if(targetDigit == 1) {
				int tail = origin % digitPosition;
				count = count + prev * digitPosition + tail + 1;
			} else {
				count = count + prev * digitPosition + digitPosition;
			}
			
			n = n / 10;
			digitPosition = digitPosition * 10;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countDigitOne(13));
	}

}
