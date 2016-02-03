package SpiralMatrix;

public class SMatrix2 {
	public int[][]generateMatrix(int n) {
		if(n == 0) {
			return new int[0][0];
		}
		int[][] matrix = new int[n][n];
		int layer = 0;
        int rowLen = n;
        int colLen = n;
        int count = 1;
        int totalNumber = n * n;
        while(layer <= Math.min(rowLen / 2, colLen / 2)) {
        	for(int i = layer; i < colLen - layer; i++) {
        		matrix[layer][i] = count;
        		count++;
        		//System.out.print(matrix[layer][i]);
        	}
        	
        	if(count == totalNumber + 1) return matrix;
        	for(int i = layer + 1; i < rowLen - layer; i++) {
        		matrix[i][colLen - 1 - layer] = count;
        		count++;
        	
        	}
        	
        	
        	if(count == totalNumber + 1) return matrix;
        	
        	for(int i = colLen - 2 - layer; i>= layer; i--) {
        		matrix[rowLen - 1 - layer][i] = count ;
        		count++;
        		
        	}
        	if(count == totalNumber + 1) return matrix;
        	
        	for(int i = rowLen - 2 - layer; i > layer; i --) {
        		matrix[i][layer] = count;
        		count++;
        		
        	}
        	if(count == totalNumber + 1) return matrix;
        	layer++;
        	
        }
		return matrix;
	}
	
	public static void main(String[] args) {
		SMatrix2 g = new SMatrix2();
		int n = 1;
		int[][] matrix = g.generateMatrix(n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println("");
		}
	}

}
