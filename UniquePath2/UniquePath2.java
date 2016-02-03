package UniquePath2;

public class UniquePath2 {
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int row = obstacleGrid.length;
	        int col = obstacleGrid[0].length;
	        int [][] paths = new int[row][col];
	        paths[0][0] = (obstacleGrid[0][0] == 0 ? 1 : 0) ;
	        for(int i = 1; i < col; i++) {
	            if(obstacleGrid[0][i] == 0) {
	                paths[0][i] = 0;
	            } else {
	                paths[0][i] = paths[0][i - 1];
	            }
	        }
	        
	        for(int i = 1; i < row; i++) {
	            if(obstacleGrid[i][0] == 0) {
	                paths[i][0] = 0;
	            } else {
	                paths[i][0] = paths[i - 1][0];
	            }
	        }
	        
	        for(int i = 1; i < row; i++) {
	            for(int j = 1; j < col; j++){
	               // (obstacleGrid[i][j] == 1) ? paths[i][j] = 0 : paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
	            	if(obstacleGrid[i][j] == 1) {
	            		paths[i][j] = 0;
	            	} else {
	            		paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
	            	}
	            }
	        }
	        
	        return paths[row - 1][col - 1];
	        
	    }
}
