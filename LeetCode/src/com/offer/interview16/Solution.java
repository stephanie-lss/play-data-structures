package com.offer.interview16;

/**
 * @author LiSheng
 * @date 2020/5/24 14:42
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickPow(x, N) : 1 / quickPow(x, -N);
    }

//    private double quickPow(double x, long N) {
//        if (N == 0) {
//            return 1;
//        }
//        double y = quickPow(x, N / 2);
//        return (N & 1) == 1 ? y * y * x : y * y;
//    }

    private double quickPow(double x, long N) {
        double res = 1.0;
        while (N != 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10));
    }
}