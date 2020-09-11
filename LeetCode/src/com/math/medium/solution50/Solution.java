package com.math.medium.solution50;

/**
 * @author LiSheng
 * @date 2020/5/11 18:51
 */
class Solution {
    public double myPow(double x, int n) {
        return n > 0 ? helper(x, (long) n) : 1 / helper(x, (long) -n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double tmp = helper(x, n / 2);
        return (n & 1) != 1 ? tmp * tmp : tmp * tmp * x;
    }
}