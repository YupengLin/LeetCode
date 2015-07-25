package SetMatrixZeros;

public class SetZeros {
	public void setZeroes(int[][] matrix) {
        int row=0;
        int col=0;
       
        boolean zero=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            //	System.out.println(matrix[i][j]);
                if(matrix[i][j]==0){
                    row=i;
                    col=j;
                    zero=true;
                    set(row,col,matrix);
                }
            }
        }
        
        if(!zero){
        //	  System.out.println("nope");
            return;
        }
       // System.out.println(row+" "+col);
      
        
    }
	   
	 private void set(int row, int col,int[][] matrix){
		 for(int i=0;i<matrix[0].length;i++){
          matrix[row][i]=0;
      }
      for(int i=0;i<matrix.length;i++){
          matrix[i][col]=0;
      }
	 }
	 public static void main(String[] args){
		 SetZeros sz=new SetZeros();
		 int[][] matrix ={{1},{0}};
		 sz.setZeroes(matrix);
		 System.out.println(matrix[0][0]);
		 System.out.println("size="+matrix.length+", "+matrix[0].length);
		 
	 }
}
