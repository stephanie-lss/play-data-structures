package com.math.medium.solution50;

/**
 * @author LiSheng
 * @date 2020/5/11 19:57
 */
public class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? helper(x, N) : 1 / helper(x, -N);
    }

    private double helper(double x, long n) {
        double res = 1.0;
        double tmp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        return res;
    }
}
