package UglyNumber;

/**
 * Created by linyupeng on 9/10/15.
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        if(num == 1) {
            return true;
        }
        if(num == 2 || num == 3 || num == 5) {
            return true;
        }
        if(isPrime(num)) {
            return false;
        }
        if(num % 2 == 0) {
            if (isPrime(num / 2)) {
                int remain = num / 2;
                if(remain == 2 || remain == 3 || remain == 5) {
                    return true;
                } else {
                    return  false;
                }
            } else {
                return isUgly(num / 2);
            }
        }
        if(num % 3 == 0) {
            if(isPrime(num / 3)) {
                int remain = num / 3;
                if(remain == 2 || remain == 3 || remain == 5) {
                    return true;
                } else {
                    return  false;
                }
            } else {
                return isUgly(num / 3);
            }
        }
        if(num % 5 ==0) {
            if(isPrime(num / 5)) {
                int remain = num / 5;
                if(remain == 2 || remain == 3 || remain == 5) {
                    return true;
                } else {
                    return  false;
                }
            } else {
                return  isUgly(num / 5);
            }
        }
        return false;
    }

    public static boolean isPrime(int num) {
        if(num == 1) {
            return true;
        }
        if(num == 2) {
            return true;
        }
        for(int i = 2; i < num - 1; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly2(int num) {
        if(num == 0) {
            return false;
        }
        while(!(num == 1)) {
            if(num % 2 == 0) {
                num = num / 2;
            } else if(num % 3 == 0) {
                num = num / 3;
            } else if(num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }
        if(num == 1) {
            return true;
        } else {
            return false;
        }
    }

   public static void main(String[] args) {
       System.out.println(isUgly(6));
       System.out.println(isUgly(8));
       System.out.println(isUgly(905391974));
   }


}
