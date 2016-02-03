package RomanToInteger;

import java.util.Stack;

public class RomanToInteger {
	public static int romanToInt(String s) {
		int total = 0;
		for(int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			char next = '0';
			if(i + 1 < s.length()) {
				next = s.charAt(i + 1);
			}
			
			int currVal = convert(curr);
			int nextVal = convert(next);
			
			if(currVal < nextVal) {
				nextVal -= currVal;
				total += nextVal;
				i++;
			} else {
				total += nextVal + currVal;
				i++;
			}
		}
		return total;
	}
	
	public static int convert(char digit) {
		int number = 0;
		switch (digit) {
		case 'I' : number = 1; break;
		case 'V' : number = 5; break;
		case 'X' : number = 10; break;
		case 'L' : number = 50; break;
		case 'C' : number = 100; break;
		case 'D' : number = 500; break;
		case 'M' : number = 1000; break;
		}
		return number;	
	}
	
	public static void main(String[] args) {
		//System.out.println(romanToInt("MCM"));
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);


		for(Integer i : stack) {
			System.out.println(i);
		}
	}
}
