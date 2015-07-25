package epic;
import java.util.*;
public class ColorfulNumber {
	
  public static boolean isColorful(int num){
	  ArrayList<Integer> store=new ArrayList<Integer>();
	  int index=0;
	  while(num>0){
		  int digit=num%10;
		  
		  num=num/10;
		  int len=store.size();
		  System.out.println("digit"+digit);
		  for(int i=index;i<len;i++){
			  
			  int product=store.get(i)*digit;
			  store.add(new Integer(product));
			  System.out.println("product"+product);
			  
		  }
		  index=len;
		  store.add(digit);
		
	  }
	  HashSet<Integer> set=new HashSet<Integer>();
	  for(int item:store){
		  System.out.print(item+" ");
	  }
	  for(int item:store){
		  if(set.contains(item)){
			  System.out.println("in check"+item);
			  return false;
		  }else{
			  set.add(item);
		  }
	  }
	  return true;
  }

  
  public static void main(String[] args){
	  System.out.println(isColorful(263));
	  System.out.println(isColorful(236));
  }
}
