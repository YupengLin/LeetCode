package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
        	return spiral;
        }
		int layer = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        //System.out.println(Math.min(rowLen / 2, colLen / 2));
        while(layer <= Math.min(rowLen / 2, colLen / 2)) {
        	for(int i = layer; i < colLen - layer; i++) {
        		spiral.add(matrix[layer][i]);
        		//System.out.print(matrix[layer][i]);
        	}
        	
        	if(spiral.size() == rowLen * colLen) return spiral;
        	for(int i = layer + 1; i < rowLen - layer; i++) {
        		spiral.add(matrix[i][colLen - 1 - layer]);
        		//System.out.print(matrix[i][colLen - 1 - layer]);
        	}
        	//System.out.println("\n===2==");
        	
        	if(spiral.size() == rowLen * colLen) return spiral;
        	for(int i = colLen - 2 - layer; i>= layer; i--) {
        		spiral.add(matrix[rowLen - 1 - layer][i]);
        		//System.out.print(matrix[rowLen - 1 - layer][i]);
        	}
        	if(spiral.size() == rowLen * colLen) return spiral;
        	//System.out.println("\n===3==");
        	for(int i = rowLen - 2 - layer; i > layer; i --) {
        		spiral.add(matrix[i][layer]);
        		//System.out.print(matrix[i][layer]);
        	}
        	if(spiral.size() == rowLen * colLen) return spiral;
        	layer++;
        	
        }
     return spiral;   
    }

	public static void main(String[] args) {
		SpiralMatrix s = new SpiralMatrix();
		int[][] matrix = {{1,2,3},{12, 13, 4},{11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
		int [][] matrix2 = {{2,3}};
		System.out.println(s.spiralOrder(matrix).toString());
	}
}
