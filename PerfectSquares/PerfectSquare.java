package PerfectSquares;

import java.util.Arrays;

public class PerfectSquare {
	
	public int numSquares(int num) {
		if(num == 0) {
			return 0;
		}
		if(num == 1) {
			return 1;
		}
		if(num == 2) {
			return 2;
		}
		if(num == 3) {
			return  3;
		}
		
		int[] square = new int[num + 1];
		Arrays.fill(square, Integer.MAX_VALUE);
		square[0] = 0;
		for(int i = 1; i <= num; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while(i - j*j >= 0) {
				min = Math.min(min, square[i - j*j] + 1);
				j++;
			}
			square[i] = min;
		}
		return square[num];
	}
	
	public static void main(String[] args) {
		PerfectSquare perf = new PerfectSquare();
		System.out.println(perf.numSquares(13));
	}

}
