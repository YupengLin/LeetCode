package MergeSortedList;

public class MergeSortList {
	public void merge(int[] A, int m, int[] B, int n){
		int [] helper=new int[m+n];
        int pos=0;

        int i=0;
        int j=0;
       
        
        
        
        	while(i<m && j<n){
                 if(A[i]<B[j]){
                 	helper[pos]=A[i];
                 	i++;
                 	pos++;
                 }else{
                    helper[pos]=B[j];
                    j++;
                    pos++;
                 }
           //  System.out.println("i="+i+";j="+j+"pos="+pos+";"+helper[pos-1]);

        	
        }
        	
        	if(j==n){
        		for(int k=i;k<m;k++,pos++){
            		helper[pos]=A[k];
            	}
        	}else if(i==m){
        		for(int k=j;k<n;k++,pos++){
            		helper[pos]=B[k];
            	}
        	}
        	
        	


        for(int k=0;k<m+n;k++){
        	
        	A[k]=helper[k];
        }

	}
	public static void main(String[] args){
		MergeSortList ms=new MergeSortList();
		int[] A={2,5,0,0,0,0,00,0,0,0,0,0,0};
		int m=2;
		int[] B={1,3,6,76};
		int n=4;

		ms.merge(A,m,B,n);
		for(int i=0;i<A.length;i++){
			System.out.print(" "+A[i]);
		}
	}
}
