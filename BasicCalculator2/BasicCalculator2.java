package BasicCalculator2;

/**
 * Created by linyupeng on 9/10/15.
 */
public class BasicCalculator2 {
    public static int calculate(String s) {
        String cleanString = parseEqu(s);
        String[] multiple = cleanString.split("\\+");
        int result = 0;
        for(String block : multiple) {
            System.out.println(block);
            result = result + evalution(block);
        }
        return result;
    }

    public static String parseEqu(String s){
        StringBuilder sectors = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char sign = s.charAt(i);
            if(sign == ' ') {
                continue;
            }
            if(sign == '-') {
                sectors.append('+');
            }
            if(sign == '/') {
                sectors.append('*');
            }
            sectors.append(sign);
        }
        return sectors.toString();
    }

    public static int evalution(String block) {
        int result =1;
        if(block.charAt(0) == '-') {
            return -1 * evalution(block.substring(1));
        }
        String[] factors = block.split("\\*");
        for(String factor : factors) {
            if(factor.charAt(0) == '/') {
                result = result / Integer.parseInt(factor.substring(1));
            } else {
                result = result * Integer.parseInt(factor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
