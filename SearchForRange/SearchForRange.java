package SearchForRange;

public class SearchForRange {
	 public int[] searchRange(int[] A, int target) {
	        int start=0;
	        int end=A.length-1;
	        int len=A.length-1;
	        int[] index=new int[2];
	        if(A.length==1){
	            if(target==A[0]){
	                index[0]=0;
	                index[1]=0;
	                return index;
	            }else{
	                index[0]=-1;
	                index[1]=-1;
	                return index;
	            }
	        }
	        
	        
	        while(start<=end){
	            int mid=(start+end)/2;
	            if(mid-1>0 && target>A[mid-1] && target<A[mid] ){
	            }
	        index[0]=-1;
	        index[1]=-1;
	        return index;
	    }
}
