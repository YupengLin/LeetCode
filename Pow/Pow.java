package Pow;

/**
 * Created by linyupeng on 9/8/15.
 */
public class Pow {
    public static double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(n >= 1) {
            return posPow(x, n);
        }

        if(n <= 1) {
            return negPow(x,n);
        }


        return 0;
    }

    public static double posPow(double x, int n) {
        if(n == 1) {
            return x;
        }

        return x * posPow(x, n - 1);
    }

    public static double negPow(double x, int n) {
        if(n == -1) {
            return 1 / x;
        }

        return (1 / x) * negPow(x, n + 1);
    }

    public static void main(String[] args){
        System.out.println(myPow(4,3));
    }
}
