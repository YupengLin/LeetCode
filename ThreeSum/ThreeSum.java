package ThreeSum;
import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num){
        if(num.length==0){
        	return null;
        }
       List<List<Integer>> result=new ArrayList<List<Integer>>();
       List<Integer> single=new ArrayList<Integer>();
       dfs(num,0,result,single);
       return result;
	}

	private void dfs(int[]num, int index, List<List<Integer>> result, List<Integer> single){
           if(single.size()==3 && sum(single)==0){
           result.add(new ArrayList<Integer>(single));
           	return;
           }
           if(index>num.length-1 ||single.size()>3){
        	   return;
           }

           for(int i=index;i<num.length;i++){
           	  single.add(num[index]);
           	  
           	  dfs(num,index+1,result,single);
           	  single.remove(single.size()-1);
              
           }

	}
	private int sum(List<Integer> single) {
		int sum=0;
		for(int item:single){
			sum=sum+item;
		}
		return sum;
	}
	
	public static void main(String[] args){
		ThreeSum ts=new ThreeSum();
		int[] nums={-1, 0, 1, 2, -1, -4};
		
		
		List<List<Integer>> ans=ts.threeSum(nums);
		
		for (List<Integer> single :ans){
			System.out.println(single.toString());
		}
	}

}
