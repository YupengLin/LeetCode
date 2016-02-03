package RangeSumQuery2D;

public class NumMatrix {
	
	int[][] dp;
	
	public NumMatrix(int[][] matrix) {
		if(matrix.length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		
		dp = new int[m+1][n+1];
		
		dp[0][0] = matrix[0][0];
		for(int i = 1; i < m; i++) {
			dp[i][0]  = dp[i - 1][0] + matrix[i][0];
		}
		for(int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + matrix[0][j];
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j ++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i][j] - dp[i - 1][j - 1];
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2][col2] - dp[col1 - 1][row2] - dp[col2][row1 - 1] + dp[row1 - 1][col1 - 1];
	}
	
	public static void main(String[] args) {
		int[][] matrix= {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		NumMatrix test = new NumMatrix(matrix);
		//System.out.println(test.dp[1][1]);
		System.out.println(test.sumRegion(1, 2, 2, 4));
	}

}
