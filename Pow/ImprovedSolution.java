package Pow;

public class ImprovedSolution {
	public double myPow(double x, int n) {
		if(x == 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		
		if(n ==  -1) {
			return  1 / x;
		}
		
		double half = myPow(x, n / 2);
		if(n % 2 == 0) {
			return half * half;
		}  else {
			if(n > 0) {
				return half * half * x;
			} else {
				return half * half / x;
			}
		}
		
	}
}
