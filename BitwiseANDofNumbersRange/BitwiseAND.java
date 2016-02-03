package BitwiseANDofNumbersRange;

public class BitwiseAND {
	public static int rangeBitwiseAnd(int m, int n) {
		int c = 0;
		while(m != n) {
			m = m >> 1;
			n = n >> 1;
			c++;
		}
		return n << c;
	}
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}
}
