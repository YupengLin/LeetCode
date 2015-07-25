package MultiThreadOne;
import java.io.*;

public class Main {
	 public static void main(String[] args) throws IOException {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    int[] input=new int[3];
		    int i=0;
		    while ((s = in.readLine()) != null) {
		          
		      System.out.println(s);
		      input[i]=Integer.parseInt(s);
		      i++;
		    }
		    
		    int A=input[0];
		    int B=input[1];
		    int N=input[2];
		    
		    int[] nums=new int[N];
		    String[] output=new String[N];
		    for( i=0;i<N;i++){
		        if((i+1)%A!=0 && (i+1)%B!=0){
		            output[i]=Integer.toString(i+1);
		        }
		        if((i+1)%A==0 && (i+1)%B!=0){
		            output[i]="F";
		        }
		         if((i+1)%A!=0 && (i+1)%B==0){
		            output[i]="B";
		        }
		        if((i+1)%A==0 && (i+1)%B==0){
		            output[i]="FB";
		        }
		        
		    }
		    
		    
		    
		  }
}
