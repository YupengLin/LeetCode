package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int [] candidates, int target){
		 List<List<Integer>> result=new ArrayList<List<Integer>>();
		  if(candidates==null || target==0){
			  return result;
		  }
		  Arrays.sort(candidates);
		  ArrayList<Integer> current=new ArrayList<Integer>();
		  
		  buildList(candidates,0,target,0,current,result);
		  
		  
		  
		  return result;
	  }
	  
	    
	    
	    private void buildList(int[] candidates,int start,int target,int currSum, ArrayList<Integer> current, List<List<Integer>>result){
		  if(target < currSum){
			  return;
		  }
		  if(target==currSum){
			  //result.add(new ArrayList<Integer>(current));
			  List<Integer> toAdd = new ArrayList<>(current);
			  if(!result.contains(toAdd)) result.add(toAdd);
			  return;
		  }
		  for(int i=start;i<candidates.length;i++){
			  if(candidates[i]>target){
				  return;
			  }
			  // Add candidate[i] to the current array
			  current.add(candidates[i]);
			  
			  
			  // Recursively append the current array to compose a solution
			  buildList(candidates,i+1,target, currSum + candidates[i],current,result);
			  // Remove candidate[i] from the current array, and try next candidate in the next loop
			  current.remove(current.size()-1);
		  }
	  }
	    
	  public static void main(String[] args) {
		  CombinationSum2 cs = new CombinationSum2();
		  int[] nums = {10,1,2,7,6,1,5};
		  List<List<Integer>> combo = cs.combinationSum2(nums ,8);
			for(List<Integer> solution : combo) {
				System.out.println(solution.toString());
			}
	  }
}
