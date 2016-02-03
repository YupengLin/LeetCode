package FractionToRecurringDecimal;

import java.util.Hashtable;

public class Fraction {
	public static String fractionToDecimal(int numerator, int denominator) {
		if(denominator == 0) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			result.append("-");
		}
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		System.out.println(num);
		
		result.append(num / den);
		if(num % den == 0) {
			return result.toString();
		}
		Hashtable<Long, Integer> position = new Hashtable<>();
		num = num % den;
		result.append(".");
		position.put(num, result.length());
		
		while(num != 0) {
			long nextDigit = (num * 10 / den);
			System.out.println("num" + num + " ; den" + den + " ;nextdigit " + nextDigit);
			num = (num * 10) % den;
			result.append(nextDigit);
			if(position.containsKey(num)) {
				int index = position.get(num);
				result.insert(index, "(");
				result.append(")");
				return result.toString();
			} else {
				position.put(num, result.length() );
			}
		}
	
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648, -1));
	}
}
