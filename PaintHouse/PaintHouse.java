package PaintHouse;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if(costs.length == 0) {
			return 0;
		}
        int[][] minCost = new int[costs.length][3];
        minCost[0][0] = costs[0][0];
        minCost[0][1] = costs[0][1];
        minCost[0][2] = costs[0][2];
    
        for(int i = 1; i < costs.length; i++) {
        	minCost[i][0] = Math.min(minCost[i - 1][1] + costs[i][0],
        							 minCost[i - 1][2] + costs[i][0]);
        	minCost[i][1] = Math.min(minCost[i - 1][0] + costs[i][1],
					 				 minCost[i - 1][2] + costs[i][1]);
        	minCost[i][2] = Math.min(minCost[i - 1][0] + costs[i][2],
					 				 minCost[i - 1][1] + costs[i][2]);
        }
        
        return Math.min(minCost[costs.length - 1][0], 
        		Math.min(minCost[costs.length - 1][1], minCost[costs.length - 1][2]));
	}
	
	public static void main(String[] args) {
		PaintHouse ph = new PaintHouse();
		int[][] costs = {{20, 18, 4}, {9, 9, 10}};
		System.out.println(ph.minCost(costs));
	}
}
