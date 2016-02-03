package SuperUglyNumber;

import java.util.HashSet;

public class SuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int[] primes) {
		if(n == 1 || primes.length == 0 || primes == null) {
			return 1;
		}
		int[] res = new int[n];
		int[] index = new int[primes.length];
		int[] value = new int[primes.length];
	                                      
		res[0] = 1;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < primes.length; j++) {
				value[j] = res[index[j]] * primes[j];
			}
			
			int currMin = Integer.MAX_VALUE;
			
			for(int k = 0; k < primes.length; k++) {
				if(value[k] < currMin) {
					currMin = value[k];	
				}
			}
			
				res[i] = currMin;
		
		for(int k = 0; k < primes.length; k++) {
					if(value[k] == currMin) {
						index[k]++;
					}
			}	
		}
		return res[n - 1];
		
	}
	
	public static void main(String[] args) {
		
		int[] primes = {2,7,13,19};
		for(int i = 1; i < 13; i++){
		System.out.println(nthSuperUglyNumber(i, primes));
		}
	}
}
