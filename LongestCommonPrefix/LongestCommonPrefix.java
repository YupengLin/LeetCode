package LongestCommonPrefix;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs){
		if(strs.length<2){
			return strs[0];
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++){
			if(strs[i].length()<min){
				min=strs[i].length();
			}
		}
		//System.out.println(min);
        String prefix="";
        int max=0;
		for(int i=0;i<min;i++){
		  
          char c0=strs[0].charAt(i);
       
          boolean isSame=true;
          for(int j=1;j<strs.length;j++){
        	   
                if(strs[j].charAt(i)!=c0){
                	isSame=false;
                	break;
                }
          }
          if(!isSame){
          	break;
          }else{
          	max++;

          }
         

		}

		return strs[0].substring(0,max);
	}
	
	public static void main(String[] args){
		LongestCommonPrefix lcp=new LongestCommonPrefix();
		String[] apples={"applff","appleb","applc","appld"};
		String prefix=lcp.longestCommonPrefix(apples);
		System.out.println(prefix);
	}
}
