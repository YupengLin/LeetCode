package PascalTriangle;
import java.util.*;
public class PascalTriangle {
	public int[][]  pascal (int row){
	    int [][] triangle=new int[row][row];
	     for(int i=0;i<row;i++){
	     	triangle[i][0]=1;
	     }
	     for(int i=1;i<row;i++){
	     	triangle[i][i]=1;
	     }
	     for(int i=2;i<row;i++){
	     	for(int j=1;j<i;j++){
	     		triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
	     	}
	     }

	     return triangle;
	    


		}
	
   public void change(int[] A){
	   A[0]=1;
	   A[1]=2;
	   A[2]=3;
   }
   public void change2(int[] A){
	  int[] B={1,2,3,4};
	  A=B;
   }
   public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> triangle=new ArrayList<List<Integer>>();
       if(numRows==0){
           return triangle;
       }
       List<Integer> line1=new ArrayList<Integer>();
       line1.add(1);
       triangle.add(line1);
       for(int i=1;i<numRows;i++){
    	   List<Integer> line=new ArrayList<Integer>();
    	   line.add(1);
    	   List<Integer> prev=triangle.get(i-1);
    	   for(int j=1;j<=i-1;j++){
    		   int value=prev.get(j-1)+prev.get(j);
    		   line.add(value);
    	   }
    	   line.add(1);
    	   triangle.add(line);
       }
       return triangle;
   }
	
  public static void main(String[] args){
	  PascalTriangle pt=new PascalTriangle();
	 // int [][] ans=pt.pascal(5);
	  /*
	  for(int i=0;i<ans.length;i++){
		  for(int j=0;j<ans[0].length;j++){
			  System.out.print(ans[i][j]+" ");
		  }
		  System.out.println(" ");
	  }
	  */
	  
	  int[] A={0,0,0};
	 
	 List<List<Integer>> pascal=pt.generate(5);
	 for(List<Integer> line:pascal){
		 System.out.println(line.toString());
	 }
	  
	  
  }
}
