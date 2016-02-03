package SingleNumber3;

/**
 * Created by linyupeng on 9/19/15.
 */
public class SingleNumber3 {
    public static int[] singleNumber3(int[] nums) {
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        int diffbit = Integer.highestOneBit(diff);
        int[] result = {0 , 0};
        for(int num : nums) {
            if((num & diffbit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
