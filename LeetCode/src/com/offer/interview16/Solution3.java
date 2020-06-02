package com.offer.interview16;

/**
 * @author LiSheng
 * @date 2020/6/2 9:16
 */
public class Solution3 {
    public double myPow(double x, int n) {
        return n > 0 ? quickPow(x, n) : 1 / quickPow(x, -n);
    }

    private double quickPow(double x, int n) {
        double res = 1.0, tmp = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().myPow(2,10));
    }
}
