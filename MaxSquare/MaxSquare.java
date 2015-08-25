package MaxSquare;

public class MaxSquare {
	
	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		
		if(row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		int[][] maxArea = new int[row][col];
		if(matrix[0][0] == '1') {
			maxArea[0][0] = 1;
		} else {
			maxArea[0][0] = 0;
		}
		for(int j = 1; j < col; j++) {
			if(matrix[0][j] == '0') {
				maxArea[0][j] = maxArea[0][j - 1];
			} else {
				maxArea[0][j] = 1;
			}
		}
		if(row == 1) {
			return maxArea[0][col - 1];
		}
		
		for(int i = 1; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int prevMax = 0;
				if(j == 0) {
					prevMax = maxArea[i - 1][j];
				} else {
					prevMax = Math.max(maxArea[i - 1][j - 1], Math.max(maxArea[i - 1][j], maxArea[i][j - 1]));
				}
				if(matrix[i][j] == '0') {
					maxArea[i][j] = prevMax;
				} else {
					int squareFromPoint = getSquareFromGivenPoint(matrix, i, j);
					maxArea[i][j] = Math.max(prevMax, squareFromPoint);
				}
			}
		}
		printMatrix(maxArea);
		return maxArea[row - 1][col - 1];
		
	}
	
	public static int getSquareFromGivenPoint(char[][] matrix, int x, int y) {
		int back = 0;
		for(; back <= Math.min(x, y); back++) {
			if(!isSquare(matrix, back, x, y)) {
				break;
			}
		}
		return back*back;
		
	}
	
	public static boolean isSquare(char[][] matrix, int back, int x, int y) {
		for(int i = x; i >= x - back; i--) {
			for(int j = y; j >= y - back; j--) {
				if(matrix[i][j] == '0') {
					return false;
				}
			}
		}
		return true;
	}
	public static void printMatrix(int[][] matrix) {
		for(int i =0; i < matrix.length; i++) {
			for(int j =0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + ", ");
			}
		System.out.println("");
		}
	}
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
		System.out.println(maximalSquare(matrix));
	}
}
