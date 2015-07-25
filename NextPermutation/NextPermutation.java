package NextPermutation;

public class NextPermutation {
public void nextPermutation(int[] num) {
        int increVio=0;
        int swapPoint=0;
        /**
         * from right to left, find the first index violate increasing trend;
         */
        for(increVio=num.length-1;increVio>0;increVio--){
      //  if(num[increVio]<=num[increVio-1]){
      //   		continue;
       //  	}
        	if(num[increVio]>num[increVio-1]){
        		break;
        	}
        	
        	
         
            	// break;
            }
            increVio--;
        	
        	if(increVio>=0){
            
        	for(swapPoint=num.length-1;swapPoint>increVio;swapPoint--){
            	if(num[swapPoint]>num[increVio]){
            		break;
            	}
        	
        	
        }
        
        /**
         * from right to left, find the first index greater than increaseViolation point
         */
        
        
        
        
        int temp=num[increVio];
        num[increVio]=num[swapPoint];
        num[swapPoint]=temp;
        	}
      //  System.out.println(increVio);
      //  System.out.println(swapPoint);
        
        int start=increVio+1;
        int end=num.length-1;
        while(start<end){
        	int swap=num[start];
        	num[start]=num[end];
        	num[end]=swap;
        	start++;
        	end--;
        }
    }

    public static void main(String[] args){
    	NextPermutation np=new NextPermutation();
    	int[] t1={1,2,3};
    	np.nextPermutation(t1);
    	for(int i=0;i<t1.length;i++){
    		System.out.print(t1[i]+" ");
    	}
    	System.out.println(" ");
    }
}
