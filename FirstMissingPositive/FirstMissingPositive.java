package FirstMissingPositive;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A){
		if(A.length==0){
			return 1;
		}
		for(int i=0;i<A.length;){
			if((A[i]!=i+1) &&(A[i]>0) && (A[i]<=A.length) &&(A[i]!=A[A[i]-1])){
				int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
			}else{
				i++;
			}
		}

		for(int i=0;i<A.length;i++){
			System.out.println(i+"; "+A[i]); 
			if(A[i]!=i+1){
				return i+1;
			}
		}
		return A.length+1;
	}
	

	public static void main(String[] args){
		FirstMissingPositive fmp=new FirstMissingPositive();
		int[] A={3,4,-1,1};
		int i=fmp.firstMissingPositive(A);
		System.out.println("ans ="+i);
	}
	
}
