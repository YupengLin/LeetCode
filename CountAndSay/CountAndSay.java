package CountAndSay;

public class CountAndSay {
  public static String count(int n){
	  if(n<0){
		  return "";
	  }
	  int i=1;
	  
	  String current="1";
	  while(i<n){
		  current=say(current);
		  i++;
	  }
	  return current;
  }
  public static String say(String current){
	  char last=current.charAt(0);
	  int count=1;
	  String ans="";
	  for(int i=1;i<current.length();i++){
		  if(current.charAt(i)==last){
			  count++;
			  
		  }else{
			  ans+=Integer.toString(count);
			 // System.out.println("count="+count);
			  ans+=Character.toString(last);
			  last=current.charAt(i);
			  count=1;
		  }
	  }
	  ans+=Integer.toString(count);
	  ans+=Character.toString(last);
	  return ans;
	  
  }
  public static void main(String[] args){
	  for(int i=0;i<5;i++){
		  System.out.println(count(i));
	  }
  }
}
