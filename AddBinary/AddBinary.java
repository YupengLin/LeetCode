package AddBinary;

public class AddBinary {
  public String addBinary(String a, String b){
	  if(a.length()==0 || a==null){
		return b;
	  }
	  if(b.length()==0 || b==null){
		  return a;
	  }
	  
	  StringBuilder sum=new StringBuilder();
	  int indexA=a.length()-1;
	  int indexB=b.length()-1;
	  int carry=0;
	  while(indexA>=0 || indexB>=0 || carry>0){
		  int num1=indexA>=0?a.charAt(indexA)-'0' :0;
		  int num2=indexB>=0?b.charAt(indexB)-'0': 0;
		  
		  int current=(num1+num2+carry)%10;
		  
		  carry=(num1+num2+carry)/10;
		  System.out.println("num1="+num1+" ;num2="+num2+";carry="+carry+"curr="+current);
		  sum.insert(0,current);
		  indexA--;
		  indexB--;
		  
	  }
	  return sum.toString();
  }
  public static void main(String[] args){
	  AddBinary ab=new AddBinary();
	  System.out.println(ab.addBinary("240", "16"));
  }
}
