package PowerOfThree;

public class Solution {
	
	public static boolean isPowerOfThree(int n) {
		if(n == 1 || n == 2) {
			return false;
		}
		while(n > 1) {
			if( n%3 != 0) {
				return false;
			}
			n = n / 3;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(3));
	}

}
