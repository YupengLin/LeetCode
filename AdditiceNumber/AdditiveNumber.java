package AdditiceNumber;

public class AdditiveNumber {

	public boolean isAdditiveNumber(String num) {
		int L = num.length();
		for(int i = 1; i <= (L / 2); i++) {
			if(num.charAt(0) == '0' && i >= 2) continue;
			for(int j = i + 1; L-j>=i && L-j >= j-i; j++) {
				if(num.charAt(i) == '0' && j-i >= 2) continue;
				
				long num1 = Long.parseLong(num.substring(0, i));
				long num2 = Long.parseLong(num.substring(i, j));
				
				String rest = num.substring(j);
				if(isAdditive(rest, num1, num2)) return true;
			}
		}
		return false;
	}
	
	public boolean isAdditive(String rest, long num1, long num2) {
		if(rest.length() == 0) return true;
		
		String result = new Long(num1 + num2).toString();
		if(!rest.startsWith(result)) {
			return false;
		}
		return isAdditive(rest.substring(result.length()), num2, num1 + num2);
		
	}
	
	public static void main(String[] args) {
		System.out.println(new AdditiveNumber().isAdditiveNumber("112358"));
	}
}
