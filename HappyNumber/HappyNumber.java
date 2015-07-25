package HappyNumber;

import java.util.ArrayList;

public class HappyNumber {
	public static boolean isHappy(int n) {
		if(n <= 0) {
			return false;
		}
		ArrayList<Integer> digits = getDigit(n);
		int squareSum = getSquareSum(digits);
		ArrayList<Integer> squareSums = new ArrayList<Integer>();		
		//System.out.println(digits.toString());
		//System.out.println("square sum = " + squareSum);
		squareSums.add(squareSum);
		while(squareSum != 1) {
			
			digits = getDigit(squareSum);
			//System.out.println(digits.toString());
			squareSum = getSquareSum(digits);
			//System.out.println("square sum = " + squareSum);
			
			//System.out.println("array = " + squareSums.toString());
			
			for(int record : squareSums) {
				if(record == squareSum) {
					return false;
				}
			}
			squareSums.add(squareSum);
		}
		
		return true;
	}
	
	public static ArrayList<Integer> getDigit(int n) {
		ArrayList<Integer> digits = new ArrayList<Integer> ();
		
		while(n != 0) {
			int digitNum = n % 10;
			digits.add(digitNum);
			n = n / 10;
		}
		return digits;
	}
	
	public static int getSquareSum(ArrayList<Integer> digits) {
		int squareSum = 0;
		
		for(int digit : digits) {
			squareSum = squareSum + digit * digit;
		}
		return squareSum;
		
	}
	
	public static void main(String[] args) {
		int[] happy = {1, 7,10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};
			for(int i : happy)
			System.out.println(isHappy(7));
		
	}
	
}
