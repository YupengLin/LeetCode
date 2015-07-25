package RotateMatrix;

public class Rotation {
	  public void rotate(int[][] matrix){
	    	int n=matrix[0].length;
	    	System.out.println("j= "+Math.ceil(((double)n)/2.));
	    	System.out.println("without ceil j= "+n/2);
		    for(int i=0;i<n/2;i++){
		    	//for(int j=0;j<Math.ceil(((double)n)/2.);j++){
		    	for(int j=0;j<(n+1)/2;j++){
		    		int temp=matrix[i][j];
		    		matrix[i][j]=matrix[n-1-j][i];
		    		matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
		    		matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
		    		matrix[j][n-1-i]=temp;
		    	}
		    }
	    }
	    
	    public  static void main(String[] args){
	    	int[][] matrix=new int[2][2];
	    	matrix[0][0]=1;
	    	matrix[1][1]=4;
	    	matrix[0][1]=2;
	    	matrix[1][0]=3;
	    	int len=matrix[0].length;
	    	
	    	
	    	 for(int i=0;i<len;i++){
				  for(int j=0;j<len;j++){
					//matrix[i][j]=(i+1)*(j+1);
					System.out.print(matrix[i][j]+" ");
				  }
				  System.out.println("");
			  }
	    	 
	    	 
	    	System.out.println("");
	    	
	    	
	    	Rotation ro=new Rotation();
	    	ro.rotate(matrix);
	    	for(int i=0;i<len;i++){
				  for(int j=0;j<len;j++){
					 System.out.print( matrix[i][j]+" ");
				  }
				  System.out.println("");
			  }
	    	
	    }

}
