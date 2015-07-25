package ValidNumber;

public class ValidNumber {
   public boolean isNumber(String s){
	   
	          s=s.replaceAll("\\s", "");
		   char[] numbers=s.toCharArray();
		   boolean isE=false;
		   boolean isDot=false;
		   boolean isNumberFirst=false;
		   if(s.length()==1 && s.equals(".")){
			   return false;
		   }
		   if(s.length()==1 && s.equals("e")){
			   return false;
		   }
		   if(s.length()==0){
		       return false;
		   }
		   
		   for(int i=0;i<numbers.length;i++){
			   if(numbers[i]==' '){
				   continue;
			   }else if(numbers[i]>='0' && numbers[i]<='9'){
				   if(i==0){
					   isNumberFirst=true;
				   }
				   continue;
			   }else if(numbers[i]=='.'){
			       if(i==0){
			           return false;
			       }
				   if(!isDot){
					   isDot=true;
					   continue;
				   }else{
					   return false;
				   }
			   }else if(numbers[i]=='e'){
				   if(i==0){
					   return false;
				   }
				   
				   if(!isE){
					   isE=true;
					   if(i+1>=numbers.length){
					       return false;
					   }
					   continue;
				   }else{
					   return false;
				   }
			   }else{
				   return false;
			   }
		   }
		   return true;
	    }
   
   public static void main(String[] args){
	   ValidNumber vn=new ValidNumber();
	   System.out.println(vn.isNumber("0"));
	   System.out.println(vn.isNumber(" 0.1"));
	   System.out.println(vn.isNumber("abc")==false);
	   System.out.println(vn.isNumber("1 a")==false);
	   System.out.println(vn.isNumber("0.  1"));
	   String s1=". 1";  // expected false
	   System.out.println(s1.length());
	   String s2=".1";
	   s1=s1.replaceAll("\\s","");
	   System.out.println(s1.length());
	   String s3="3.";  //
   }
}
