package MaximumSubarray;

public class MaxSubarray {
	   public int maxSubArray(int[] A) {
	        int[] sum=new int[A.length];
	        int max=A[0];
	        sum[0]=A[0];
	        for(int i=1;i<A.length;i++){
	            int temp=sum[i-1]+A[i];
	            sum[i]=Math.max(temp,A[i]);
	            max=Math.max(sum[i],max);
	        }
	        return max;
	        
	    }
	   
	   public static void main(String[] args){
		   MaxSubarray ms=new MaxSubarray();
		   
	   }

}
