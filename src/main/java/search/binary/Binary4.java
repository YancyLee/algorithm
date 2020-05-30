package search.binary;

import java.util.Arrays;

/**
 * 给定两个整数，被除数dividend 和 除数divisor，将两数相除，要求不使用乘法，除法和mod运算。
 *
 * 返回被除数dividend 除以除数divisor得到的商。
 */
public class Binary4 {


    public static void main(String[] args) {
        System.out.println(div(12,12));
    }

    /**
     * 初始解题思路：
     * 1，使用二分查找法，最小数为1，也就是除数和被除数一致。 最大为除数，也就是被除数为1。负数的则全部转换成正数操作。
     *    当只有一个负数时则为负，两个负数则为正
     * @param dividend
     * @param divisor
     * @return
     */
    public static int div(int dividend,int divisor){
        boolean symbol = true;
        if (dividend < 0 || divisor < 0) {
            if (!(dividend < 0 && divisor < 0)) {
                symbol = false;
            }
        }
        int mid = 0;
        int low = 1;
        int high = Math.abs(divisor);
        int divisor1 =  Math.abs(dividend);
        int sum;
        while (low < high) {
            sum = 0;
            mid = (low + high) >>> 1;
            for (int i =0;i < mid;i++) {
                sum+=divisor1;
            }
            if (Math.abs(divisor) - sum >= divisor1) {
                low = mid;
            } else if (Math.abs(divisor) - sum < 0){
                high = mid;
            } else {
                return symbol?mid:-mid;
            }
        }
        return symbol?mid:-mid;
    }

}
