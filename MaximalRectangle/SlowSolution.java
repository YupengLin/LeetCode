package MaximalRectangle;

public class SlowSolution {
  private int maxArea(char[][] matrix, int row, int col){
	  int maxArea=0;
	  
	  int minWidth=Integer.MAX_VALUE;
	  for(int i=row;i<matrix.length && matrix[i][col]=='1';i++){
		  int width=0;
		  while(col+width<matrix[0].length && matrix[i][col+width]=='1'){
			  width++;
		  }
		  if(width<minWidth){
			  minWidth=width;
		  }
		  int area=(i-row+1)*minWidth;
		  if(area>maxArea){
			  maxArea=area;
		  }
	  }
	  
	  
	  return maxArea;
  }
  
  public int maximalRectangle(char[][] matrix){
	  int maxS=0;
	  for(int i=0;i<matrix.length;i++){
		  for(int j=0;j<matrix[0].length;j++){
			  if(matrix[i][j]=='1'){
				  int square=maxArea(matrix,i,j);
				  System.out.println("i="+i+";j="+j+";square="+square);
			  if(square>maxS){
				  maxS=square;
			  }
			  
			  }
			  
			  
		  }
	  }
	  return maxS;
  }
  
  public static void main(String[] args){
	  char[][] matrix={{'0','0','1','0'},
	                   {'1','1','1','1'},
	                   {'1','1','1','1'},
	                   {'1','1','1','0'},
	                   {'1','1','0','0'},
	                   {'1','1','1','1'},
	                   {'1','1','1','0'}
	                   };
	 SlowSolution ss=new SlowSolution();
	 System.out.println(ss.maximalRectangle(matrix));
	  
  }
}
