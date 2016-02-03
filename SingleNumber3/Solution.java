package SingleNumber3;

/**
 * Created by linyupeng on 9/19/15.
 */
public class Solution {
    public static int singleNumber(int[] num) {
        int diffNumber = num[0];
        for(int i = 1; i < num.length; i++) {
            diffNumber ^= num[i];
        }
        return diffNumber;
    }
    public static void main(String[] args) {
        int[] test = {2,2,3,3,5};
        System.out.println(singleNumber(test));
    }
}
