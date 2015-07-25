package MaxProductSubarray;

public class MaxProduct {
	  public int maxProduct(int[] A) {
	        if(A.length==0){
	            return 0;
	        }
	        int maxLocal=A[0];
	        int maxGlobal=A[0];
	        int minLocal=A[0];
	        
	        for(int i=1;i<A.length;i++){
	            int temp1=maxLocal*A[i];
	            int temp2=minLocal*A[i];
	            
	             maxLocal=Math.max(Math.max(temp1,temp2),A[i]);
	             minLocal=Math.min(Math.min(temp1,temp2),A[i]);
	            
	            maxGlobal=Math.max(maxGlobal,maxLocal);
	            
	            
	        }
	        return maxGlobal;
	    }
}
