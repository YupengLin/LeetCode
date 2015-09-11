import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyupeng on 9/10/15.
 */
public class UglyNumber2 {
    public static int nthUglyNumber(int n) {
        List<Integer> uglyNumber = new ArrayList<>();
        uglyNumber.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(uglyNumber.size() < n) {
            int u2 = uglyNumber.get(index2);
            int u3 = uglyNumber.get(index3);
            int u5 = uglyNumber.get(index5);
            int toAdd = Math.min(u2 * 2, Math.min(u3 * 3, u5 * 5));
            uglyNumber.add(new Integer(toAdd));
            while(index2 < uglyNumber.size() - 1  && uglyNumber.get(index2) * 2 <= uglyNumber.get(uglyNumber.size() - 1)) {
                index2++;
            }
            while(index3 < uglyNumber.size() - 1 && uglyNumber.get(index3) * 3 <= uglyNumber.get(uglyNumber.size() - 1)) {
                index3++;
            }
            while(index5 < uglyNumber.size() - 1 && uglyNumber.get(index5) * 5 <= uglyNumber.get(uglyNumber.size() - 1)) {
                index5++;
            }
        }
        return uglyNumber.get(uglyNumber.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

}
