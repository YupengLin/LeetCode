package CombinationalSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
  public List<List<Integer>> combinationSum(int [] candidates, int target){
	 List<List<Integer>> result=new ArrayList<List<Integer>>();
	  if(candidates==null || target==0){
		  return result;
	  }
	  Arrays.sort(candidates);
	  ArrayList<Integer> current=new ArrayList<Integer>();
	  
	  buildList(candidates,0,target,current,result);
	  
	  
	  
	  return result;
  }
  
  private void buildList(int[] candidates,int start,int target, ArrayList<Integer> current, List<List<Integer>>result){
	  if(target<0){
		  return;
	  }
	  if(target==0){
		  result.add(new ArrayList<Integer>(current));
	  }
	  for(int i=start;i<candidates.length;i++){
		  if(candidates[i]>target){
			  break;
		  }
		  // Add candidate[i] to the current array
		  current.add(candidates[i]);
		  // Recursively append the current array to compose a solution
		  buildList(candidates,i,target-candidates[i],current,result);
		  // Remove candidate[i] from the current array, and try next candidate in the next loop
		  current.remove(current.size()-1);
	  }
  }
  
  public static void main(String[] args){
	  
  }
}
