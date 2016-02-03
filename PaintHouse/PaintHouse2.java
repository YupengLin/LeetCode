package PaintHouse;

public class PaintHouse2 {
	 public int minCostII(int[][] costs) {
			if(costs.length == 0) {
				return 0;
			}
			
	        int row = costs.length;
	        int col = costs[0].length;
	        int[][] minCost = new int[row][col];
	        for(int i = 0; i < col; i++) {
	        	minCost[0][i] = costs[0][i];
	        }
	        for(int i = 1; i < row; i++) {
	        	for(int j = 0; j < col; j++) {
	        		minCost[i][j] = Integer.MAX_VALUE;
	        		for(int k = 1; k < col; k++) {
	        			minCost[i][j] = Math.min(minCost[i - 1][(j + k) % col] + costs[i][j],
	        									 minCost[i][j]);
	        		}
	        	}
	        }
	       int minimum = Integer.MAX_VALUE;
	       for(int i = 0; i < col; i++) {
	        	minimum = Math.min(minimum, minCost[row - 1][i]);
	        }
	       return minimum;
	    }
	 
	 public int fastMinCost(int[][] costs) {
		 if(costs.length == 0) {
			 return 0;
		 }
		 
	     int row = costs.length;
	     int col = costs[0].length;
	     int[][] minCost = new int[row][col];
	     int minIdx = -1;
	     int secIdx = -1;
	     int minValue = Integer.MAX_VALUE;
	     int secValue = Integer.MAX_VALUE;
	     for(int i = 0; i < col; i++) {
	        	minCost[0][i] = costs[0][i];
	        	if(minCost[0][i] < minValue) {
	        		secValue = 
	        	}
	        }
		 
	 }
	 public static void main(String[] args) {
			PaintHouse2 ph = new PaintHouse2();
			int[][] costs = {{20, 18, 4}, {9, 9, 10}};
			System.out.println(ph.minCostII(costs));
		}
}
