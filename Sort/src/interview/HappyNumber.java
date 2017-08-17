package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/14.
 */
public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        if(n < 1)
            return false;
        HashSet<Integer> set = new HashSet<>(32);
        int tmp;
        int newN;

        while(n > 1){
            set.add(n);
            newN = 0;
            while (n > 0) {
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }
            n = newN;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }
}
