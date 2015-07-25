package epic;
import java.util.*;

public class balancedString {
 public boolean isBalanced(String s){
	 if(s.length()==0){
		 return true;
	 }
	 Stack<Character> par=new Stack<Character>();
	 for(int i=0;i<s.length();i++){
		 char c=s.charAt(i);
//		 if(c!='(' || c!='{' || c!='['){
//			 continue;
//		 }
		 if(c=='(' || c=='{' || c=='['){
			 par.push(c);
		 }
		 if(c==')'){
			 if(!par.isEmpty()){   // contain { [ (
				 char open=par.pop();
				 if(open!='('){
					 return false;
				 }
			 }else{
				 return false;
			 }
		 }
		 
		 if(c=='}'){
			 if(!par.isEmpty()){
				 char open=par.pop();
				 if(open!='{'){
					 return false;
				 }
			 }else{
				 return false;
			 }
		 }
		 
		 if(c==']'){
			 if(!par.isEmpty()){
				 char open=par.pop();
				 if(open!='['){
					 return false;
				 }
			 }else{
				 return false;
			 }
		 }
		 
		 
	 }
	 if(par.size()==0){
		 return true;
	 }else{
		 return false;
	 }
	 
 }
 
 public static void main(String[] args){
	 balancedString bs=new balancedString();
	 String s1="a[b]c(d)f(g){}";
	 String s2="a[bb]cc[d";
	 
	 System.out.println(bs.isBalanced(s1));
	 System.out.println(bs.isBalanced(s2));
 }
}
