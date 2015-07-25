package Combinations;
import java.util.*;
public class Solution {
	 public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	        if (n<=0||k<=0){
	            return null;
	        }
	        
	        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	        
	        int st=1;
	        int num=0;
	        ArrayList<Integer> subResult=new ArrayList<Integer>();
	        buildResult(st, num, k, n, subResult, result);
	        
	        return result;
	    }
	    
	    // DFS classical format
	    private void buildResult(int start, int currentNum, int k, int n, ArrayList<Integer> subResult, ArrayList<ArrayList<Integer>> result)
	    {
	        if (currentNum==k){
	            ArrayList<Integer> temp=new ArrayList<Integer>(subResult);
	            result.add(temp);
	            return;
	        }
	        
	        for (int i=start; i<=n; i++){
	            subResult.add(i);
	            buildResult(i+1, currentNum+1, k, n, subResult, result);
	            subResult.remove(subResult.size()-1);
	        }
	    }
	    
	    public static void main(String[] args){
	  	 Solution cm=new Solution();
	  	  ArrayList<ArrayList<Integer>> combo=cm.combine(4,2);
	  	  for(ArrayList subset: combo){
	  		  System.out.println(subset.toString());
	  	  }
	    }
}
