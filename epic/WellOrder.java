package epic;
import java.util.*;
public class WellOrder {
  public static List<String> wellOrder(int n){
	  List<String> well=new ArrayList<String>();
	  if(n==0){
		  return well;
	  }
	  String item="";
	  dfs(well,item,0,n);
	  return well;
	  
  }
  public static void dfs(List<String> well, String s, int curr,int size){
	  if(s.length()==size){
		  String toAdd=new String(s);
		  well.add(s);
		  return;
	  }
	  for(int i=curr+1;i<=9;i++){
		  s=s+Integer.toString(i);
		  dfs(well,s,i,size);
		  s=s.substring(0,s.length()-1);
	  }
  }
  
  public static void main(String[] args){
	  List<String> well=wellOrder(3);
	  for(String item: well){
		  System.out.println(item);
	  }
  }
}
