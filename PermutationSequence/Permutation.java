package PermutationSequence;
import java.util.*;

public class Permutation {
  public String getPermutation(int n, int k){
	  ArrayList<String> permutation=new ArrayList<String>();
	  ArrayList<String> nums=new ArrayList();
	  for(int i=0;i<n; i++){
		 
		  nums.add(i,Integer.toString(i+1) ); 
	  }
	  System.out.println("display arraylist");
	  for(String i:nums){
		  System.out.println(i);
	  }
	  String subset="";
	  dfs(k,0,n,subset,nums,permutation);
	  return permutation.get(k-1);
  }
  private void dfs(int k,int curr,int n,String subset,ArrayList<String>nums,ArrayList<String>permutation){
	  if(curr==n){
		  permutation.add(new String(subset));
	      return;
	  }
	  if(permutation.size()==k){
		  return;
	  }
	  for(String i:nums){
		  subset=subset+i;
		  ArrayList<String> shrinkSet=new ArrayList(nums);
		 int index=nums.indexOf(i);
		  shrinkSet.remove(index);
		  
		  dfs(k,curr+1,n,subset,shrinkSet,permutation);
		  subset=subset.substring(0,subset.length()-1);
	  }
  }
  
  public static void main(String[] args){
	  Permutation pm=new Permutation();
	 // System.out.println(pm.getPermutation(8, 8590));
	  System.out.println(pm.getPermutation(9,113));
  }
  
}
