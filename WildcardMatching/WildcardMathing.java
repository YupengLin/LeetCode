package WildcardMatching;

public class WildcardMathing {
	  public boolean isMatch(String s,String p){
	         if(p==null || p.length()==0){
	         	return false;
	         }
	        // if(s.length()<p.length()){
	       // 	 return false;
	       //  }
	      return isMatch(s,0,p,0);
	    }

	    private boolean isMatch(String s, int i,String p,int j){
	        if(i==s.length() && j==p.length()){
	        	return true;
	        	
	        }else if(i==s.length() && j==p.length()-1){
	        	return true;
	        }
	        
	        else if((i==s.length() && j!=p.length()) ||(i!=s.length() && j==p.length())){
	        	return false;
	        }
	        else if(s.charAt(i)==p.charAt(j)){
	        	return isMatch(s,i+1,p,j+1);
	        }else if(p.charAt(j)=='?'){
	        	return isMatch(s,i+1,p,j+1);
	        }else if(p.charAt(j)=='*'){
	        	return isMatch(s,i+1,p,j);
	        }else{
	        	return false;
	        }

	    }
	    
	    public static void main(String[] args){
	    	WildcardMathing wm=new WildcardMathing();
	    	System.out.println(wm.isMatch("aa","a"));
	    	System.out.println(wm.isMatch("aa","aa"));
	    	System.out.println(wm.isMatch("aaa","aa"));
	    	System.out.println(wm.isMatch("aa","*"));
	    	System.out.println(wm.isMatch("aa","a*"));
	    	System.out.println(wm.isMatch("ab","?*"));
	    	System.out.println(wm.isMatch("aab","c*a*b"));
	    	System.out.println(wm.isMatch("aab","aab*"));

	    }
	    
}
