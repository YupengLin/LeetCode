package hIndex;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by linyupeng on 9/6/15.
 */
public class hIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            int tempIndex = Math.min(citations[i], citations.length - i);
            //System.out.println("temp index = " + tempIndex);
            index = Math.max(tempIndex, index);
            //System.out.println("current index" + index);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] cite = {3, 0, 6, 1, 5};
        System.out.println(hIndex(cite));
    }
}
