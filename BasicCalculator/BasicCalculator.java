package BasicCalculator;
import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {
        Stack<String> elements = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(c == '(') {
                elements.push(String.valueOf(c));
            }
            if(c >= '0' && c <= '9') {
                int j = i + 1;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                elements.push(s.substring(i, j));
              //  System.out.println(s.substring(i, j));
              //  System.out.println("=========");
                i = j - 1;
            }
            if( c == ')') {
                int tempSum = 0;
                while(!elements.empty() && !elements.peek().equals("(")) {
                    String num = elements.pop();
                    String sign = "+";
                    if(!elements.empty() && !elements.peek().equals("(")) {
                        sign = elements.pop();
                    }
                    System.out.println("num = " + num);
                    if(sign.equals("+")) {
                        tempSum = tempSum + Integer.parseInt(num);
                    } else {
                        tempSum = tempSum - Integer.parseInt(num);
                    }
                }
                elements.pop(); /*pop the '('*/
                elements.push(Integer.toString(tempSum));
            }

            if(c == '+' || c == '-') {
                elements.push(Character.toString(c));
            }
        }
        int ans = 0;

        while(!elements.isEmpty()) {
            String number = elements.pop();
            System.out.println(number);
            String sign = "+";
            if(!elements.empty()) {
                 sign = elements.pop();
            }
            System.out.println(sign);
            if(sign.equals("+")) {
                ans = ans + Integer.parseInt(number);

            } else {
                ans = ans - Integer.parseInt(number);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(calculate("12 + 1"));
        // System.out.println(calculate(" 2-1 + 2 "));
       // System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
