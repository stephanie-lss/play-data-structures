package com.offer.interview16;

/**
 * @author LiSheng
 * @date 2020/6/2 9:09
 */
public class Solution2 {
    public double myPow(double x, int n) {
        return n > 0 ? quickPow(x, n) : 1 / quickPow(x, -n);
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return ((n & 1) == 1 ? y * y * x : y * y);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().myPow(2, 10));
    }
}
