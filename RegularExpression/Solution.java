package RegularExpression;

public class Solution {
	public boolean isMatch(String s, String p){
		if(p.length()==0){
			return s.length()==0;
		}
		if(p.length()==1 || p.charAt(1)!='*'){
			if((p.charAt(0)!='.' && p.charAt(0)!=s.charAt(0)) || s.length()<1){
				return false;
			}
			return isMatch(s.substring(1),p.substring(1));
			
		}else{
			int i=-1;
			int len=s.length();
			while(i<len && (i<0 || p.charAt(0)=='.' || s.charAt(i)==p.charAt(0))){
				if(isMatch(s.substring(i+1),p.substring(2))){
					return true;
				}
				i++;
			}
			return false;
			
			
		}
		
		
		
	}
	public static void main(String[] args){
		Solution sl=new Solution();
		System.out.println(sl.isMatch("aab","c*a*b"));
	}
	
}
