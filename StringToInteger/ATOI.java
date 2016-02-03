package StringToInteger;

public class ATOI {
	public static  int myAtoi(String str) {
        str = str.trim();
     
        long num = 0;
        int sign = 1;
        int start = 0;
        if(str.length() == 0 || str == null) {
        	return 0;
        }
        if(str.charAt(0) == '+') {
        	sign = 1;
        	start++;
        } else if(str.charAt(0) == '-') {
        	sign = -1;
        	start++;
        } 
        for(int i = start; i < str.length(); i++) {
        	char digit = str.charAt(i);
        	if(digit >= '0' && digit <= '9') {
        		num = num * 10 + digit - '0';
        		if(sign == 1 && num  * sign > Integer.MAX_VALUE) {
        			return Integer.MAX_VALUE;
        		}
        		if(sign == -1 && num  * sign < Integer.MIN_VALUE) {
        			return Integer.MIN_VALUE;
        		}
        	} else {
        		return  (int)(sign * num);
        	}
        }
        return  (int)(sign * num);
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("1.4"));
		//String
		
	}
}
