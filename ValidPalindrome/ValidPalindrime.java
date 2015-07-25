package ValidPalindrome;

public class ValidPalindrime {
	
	public boolean isPalindrome(String s){
		if(s.length()==0){
			return true;
		}
		
		char [] sen=s.toCharArray();
		int start=0;
		int end=sen.length-1;
		char front='/';
		char tail='/';
		while(start<end){
			if(isValid(sen[start]) && isValid(sen[end]) ){
				
				
				
				if(isValidNum(sen[start])){
					front=sen[start];
				}else{
					front=Character.toLowerCase(sen[start]);
				}
				
				if(isValidNum(sen[end])){
					tail=sen[end];
				}else{
					tail=Character.toLowerCase(sen[end]);
				}
				System.out.println("front="+front);
				System.out.println("tail="+tail);
				
				if(tail==front){
					System.out.println("start"+start);
					System.out.println("end"+end);
					start++;
					end--;
					System.out.println("start"+start);
					System.out.println("end"+end);
					
					
					continue;
				}else{
					return false;
				}
				
				
				
				
			}else if(!isValid(sen[start]) && isValid(sen[end])){
			   start++;
			   continue;
			}else if(isValid(sen[start]) && !isValid(sen[end])){
				end--;
				continue;
			}else{
				start++;
				end--;
				continue;
			}
		}
		return true;
	}
	
	private boolean isValid(char a){
		return isValidNum(a) || isValidChar(a); 
	}
	
	private boolean isValidNum(char a){
		if(a>='0' && a<='9'){
			return true;
		}else{
			return false;
		}
	}
		
		private boolean isValidChar(char a){
		 if(a>='A' && a<='Z'){
			return true;
		}else if(a>='a' && a<='z'){
			return true;
		}else{
			return false;
		}
		
	}
		
	public static void main(String[] args){
		ValidPalindrime vp=new ValidPalindrime();
	//	System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("1a2"));
	}
	
	

}
