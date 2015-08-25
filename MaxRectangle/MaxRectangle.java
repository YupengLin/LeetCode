package MaxRectangle;

public class MaxRectangle {
	public static int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if(row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		int [][] max= new int[row][col];
		if(row == 0 && col == 0) {
			return 0;
		}
		if(matrix[0][0] == '1') {
			max[0][0] = 1;
		} else {
			max[0][0] = 0;
		}
		for(int i = 1; i < col; i++) {
			if(matrix[0][i] == '0') {
				max[0][i] = max[0][i-1];
			} else {
				max[0][i] = Math.max(getLocalSquareByFirstRow(matrix, i, 0), max[0][i-1]);
			}
		}
		
		if(row == 1) {
			return max[0][col-1];
		}
		
		
		
		for(int i = 1; i < row; i++){
			for(int j = 0; j < col; j++){
				int prevMax = 0;
				if(j == 0 ) {
					prevMax = max[i-1][j];
				} else {
			
				int tempMax = Math.max(max[i-1][j], max[i][j-1]);
				prevMax= Math.max(tempMax, max[i-1][j-1]);
				}
				if(matrix[i][j] == '0') {
					max[i][j] = prevMax;
				} else {
					int localSquare = getLocalSquare(matrix, row, col, i, j);
					max[i][j] = Math.max(localSquare, prevMax);
				}
			}
		}
		return max[row - 1][col - 1];
    }
	
	public static int getLocalSquareByFirstRow(char[][] matrix, int pos, int given) {
		int area = 0;
		while( pos >= 0 && matrix[given][pos] != '0'  ) {
			area++;
			pos--;
		}
		return area;
	}
	
	
	
	public static int getLocalSquare(char[][] matrix, int row, int col, int x, int y) {
		int area = 0;
		int minColArea = Integer.MAX_VALUE;
		int numRow = 0;
		while( x >= 0 && matrix[x][y] == '1' ) {
			int local = getLocalSquareByFirstRow(matrix,y,x);
			minColArea = Math.min(local, minColArea);
			numRow++;
			area = Math.max(area, numRow*minColArea);
			x--;
		}
		return area;
		
		
	}
	/*
	 * 1 0 1 0 0
	   1 0 1 1 1
	   1 1 1 1 1
	   1 0 0 1 0
	 */
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
						   {'1','0','1','1','1'},
						   {'1','1','1','1','1'},
						   {'1','0','0','1','0'}};
		char[][] m2 = {{'0','0','0'},
						 {'0','0','0'},
						 {'0','0','0'},
						 {'0','0','0'}};
		char[][] single = {{'0','1','1','1','1','1','0','1'}};
		System.out.println(maximalRectangle(single));
	}
	
}
