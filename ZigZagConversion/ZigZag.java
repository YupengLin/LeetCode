package ZigZagConversion;

import java.util.*;

public class ZigZag {
   public String convert(String s, int nRows){
	   LinkedList<LinkedList<Character>> zig=new LinkedList<LinkedList<Character>>();
	   for(int i=0;i<nRows;i++){
		   zig.add(new LinkedList<Character>());
	   }
	   int level=0;
	   if(nRows==1){
		   return s;
	   }
	   
	   boolean down=true;  // 
	   for(int i=0;i<s.length();i++){
		   System.out.println("levle="+level);
		   System.out.println("char="+s.charAt(i));
		   
		   LinkedList<Character> curr=zig.get(level);
		   curr.add(s.charAt(i));
		   if(down){
			   if(level<nRows-1){
				   level++;
			   }else{
				   down=false;
				   level--;
			   }
		   }else{
			   if(level>0){
				   level--;
			   }else{
				   down=true;
				   level++;
			   }
		   }
		   
	   }
	   
	   StringBuilder result=new StringBuilder();
	   for( LinkedList<Character> curr :zig){
		   for(char c:curr){
			   result.append(c);
		   }
	   }
	   
	   
	   
	   return result.toString();
   }

  public static void main(String[] args){
	  ZigZag zz=new ZigZag();
	  String s="AB";
	  System.out.println(zz.convert(s,1));
  }

}
