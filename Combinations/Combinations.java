package Combinations;
import java.util.*;

public class Combinations {
  public List<List<Integer>> combine(int n, int k){
	  List<List<Integer>> combo=new ArrayList<List<Integer>>();
	  List<Integer> subset=new ArrayList<Integer>();
	 int start=1;
	 int num=0;
	  dfs(start,num,k,n,combo,subset);
	  return  combo;
  }
  
  
  private void dfs(int start,int curr, int k, int n, List<List<Integer>> combo,List<Integer> subset){
	  if(curr==k){
		  List<Integer> ans=new ArrayList<Integer>(subset);
		  combo.add(ans);
		  return;
	  }
	  for(int i=start;i<=n;i++){
		
		  subset.add(i);
		  dfs(i+1,curr+1,k,n,combo,subset);
		  //subset.remove(subset.size()-1);
	  }
  }
  
  public static void main(String[] args){
	  Combinations cm=new Combinations();
	  List<List<Integer>> combo=cm.combine(4,2);
	  for(List subset: combo){
		  System.out.println(subset.toString());
	  }
  }
}
