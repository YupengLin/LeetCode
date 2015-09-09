package AddDigit;

import java.util.ArrayList;

/**
 * Created by linyupeng on 9/8/15.
 */
public class addDigit {
    public static int addDigits(int num) {
        if(num >= 0 && num <= 9) {
            return num;
        }
        ArrayList<Integer> digits = breakDigit(num);
        while(digits.size() > 1) {
            num = 0;
            for(int n : digits) {
                num = num + n;
            }
            digits = breakDigit(num);
        }
        return digits.get(0);
    }

    public static ArrayList<Integer> breakDigit(int num) {
        ArrayList<Integer> digits = new ArrayList<>();

        if(num >= 0 && num <= 9) {
            digits.add(num);
            return digits;
        }
        while(num != 0) {
            int single = num % 10;
            digits.add(single);
            num = num / 10;
            System.out.println("num " + num);
            System.out.println("digit " + single);
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println("a");
        System.out.println(addDigits(38));
        System.out.println("a");
    }


}
