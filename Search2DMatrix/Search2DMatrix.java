package Search2DMatrix;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target){
		int row=matrix.length;
		int col=matrix[0].length;
           
		int RowStart=0;
		int RowEnd=row-1;
		while(RowStart<=RowEnd){
		     int i=(RowStart+RowEnd)/2;
             if(target>=matrix[i][0] && target<=matrix[i][col-1]){
             	int start=0;
             	int end=col-1;
             	while(start<=end){
             		int mid=(start+end)/2;
             		if(matrix[i][mid]==target){
             			return true;
             		}
             		if(matrix[i][mid]>target){
             			end=mid-1;
             		}else{
             			start=mid+1;
             		}
             	}
             }
             else if(target<matrix[i][0]){
            	 RowEnd=i-1;
             }
             else{
            	 RowStart=i+1;
             }
             
		}

		
		return false;
	}
	public static void main(String[] args){
		int[][]matrix={{1,3,5,7},{10,11,16,20},{23,30,24,50}};
		Search2DMatrix sm=new Search2DMatrix();
		System.out.println(sm.searchMatrix(matrix, 1));
		System.out.println(sm.searchMatrix(matrix, 10));
		System.out.println(sm.searchMatrix(matrix, 23));
		System.out.println(sm.searchMatrix(matrix, 50));
	}
}
