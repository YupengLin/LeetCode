package GasStation134;

public class GasStation {
	public int complex(int[] gas, int[] cost){
		int stationNumber=gas.length;
		int leftOver=0;
		
		for(int index=1; index<=stationNumber;index++ ){
			for(int traveled=index;traveled<=(traveled%stationNumber);traveled++){
				int current=traveled%stationNumber;
				if(leftOver+gas[current]>=cost[current]){
					leftOver=leftOver+gas[current]-cost[current];
					if(current==index){
						return index;
					}
				}
			}
		}
		
		
		
		return -1;
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost){
//	  int[] diff=new int[gas.length];
//	  int leftOver=0;
//	  for(int i=0;i<=gas.length;i++){
//		  diff[i]=gas[i]-cost[i];
//		  leftOver=leftOver+diff[i];
//	  }
//	  if(leftOver<0){
//		  return -1;
//	  }
	  int index=0;
	  int oilStat=0;
	  int start=0;
	  int leftOver=0;
	  while(index<gas.length){
		  oilStat=oilStat+gas[index]-cost[index];
		  if(oilStat<0){
			  start=index+1;
			  oilStat=0;
		  }else{
			  index++;
		  }
		  leftOver=leftOver+gas[index]-cost[index];
		  
	  }
	 return leftOver>0 ?start:-1;
	  
	}
	
	public static void main(String[] args){
		System.out.println("hello");
	}
}
