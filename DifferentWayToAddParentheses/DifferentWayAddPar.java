package DifferentWayToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyupeng on 9/10/15.
 */
public class DifferentWayAddPar {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();

        if(input.length() == 0) {
            return results;
        }
        for(int i= 0; i < input.length(); i++){
            if(input.charAt(i) == '+' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1, input.length());
                List<Integer> sectors1 = diffWaysToCompute(part1);
                List<Integer> sectors2 = diffWaysToCompute(part2);
                for(Integer factor1 : sectors1) {
                    for(Integer factor2 : sectors2) {
                        int answer = 0;
                        switch(input.charAt(i)) {
                            case '+': answer = factor1 + factor2; break;
                            case '-': answer = factor1 - factor2; break;
                            case '*': answer = factor1 * factor2; break;
                        }
                        results.add(answer);
                    }
                }
            }
        }
        if(results.isEmpty()) {
            results.add(Integer.parseInt(input));
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> answer = diffWaysToCompute("2*3-4*5");
        for(Integer single : answer) {
            System.out.println(single);
        }
    }
}
