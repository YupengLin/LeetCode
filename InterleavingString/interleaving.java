package InterleavingString;

public class interleaving {
  public boolean isInterleave(String s1,String s2, String s3){
	  int m=s1.length();
	  int n=s2.length();
	  boolean[][]  inter=new boolean[m+1][n+1];
	  inter[0][0]=true;
	  
	  
	  if(s1.length() +s2.length() != s3.length()){
	      return false;
	  }
	  
	  for(int i=1;i<=m;i++){
		boolean state=s1.charAt(i-1)==s3.charAt(i-1);
			inter[i][0]=inter[i-1][0] && state;
		}
	  for(int j=1;j<=n;j++){
		  boolean state=s2.charAt(j-1)==s3.charAt(j-1);
		  inter[0][j]=inter[0][j-1] && state;
	  }
	  
	  for(int i=1;i<=m;i++){
		  for(int j=1;j<=n;j++){
			  char c1=s1.charAt(i-1);
			  char c2=s2.charAt(j-1);
			  char c3=s3.charAt(i+j-1);
			  
			  boolean state13= (c1==c3) ;
			  boolean state23=  c2==c3;
			  if(state13){
				  inter[i][j]=inter[i-1][j] && state13;
			  }
			  if (state23){
				  inter[i][j]=(inter[i][j-1] && state23) || inter[i][j];
			  }
			  
		  }
	  }
	  
	  return inter[m][n];
	  
  }
  
  public static void main(String[] args){
	 interleaving il=new interleaving();
	 String s1="aabcc";
	 String s2="dbbca";
	 String s3="aadbbbaccc";
	 System.out.println(il.isInterleave(s1, s2, s3));
  }
}
