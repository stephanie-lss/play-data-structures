package com.solution343;

/**
 * @author LiSheng
 * @date 2020/7/30 9:10
 */
public class Solution5 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int div = n / 3;
        int mod = n % 3;
        if (mod == 1) {
            return (int) Math.pow(3, div - 1) * 4;
        } else if (mod == 2) {
            return (int) Math.pow(3, div) * mod;
        } else {
            return (int) Math.pow(3, div);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().integerBreak(58));
    }
}
