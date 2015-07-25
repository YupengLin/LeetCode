package SingleNumber;

import java.util.*;

public class SingleNumber2 {
	
	public int singleNumber(int[] A){
		HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(!count.containsKey(A[i])){
				count.put(A[i], 1);
			}else{
				int times=count.get(A[i])+1;
				count.put(A[i], times);
			}
		}
	   Iterator<Integer> it=count.keySet().iterator();
	   while(it.hasNext()){
		   int key=it.next();
		   int num=count.get(key);
		   if(num!=3){
			   return key;
		   }
	   }
	   return 0;
		
	}

}
