package com.offer.interview43;

/**
 * @author LiSheng
 * @date 2020/5/21 10:37
 */
class Solution {
    public int countDigitOne(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int pow = (int) Math.pow(10, s.length() - 1);
        int high = n / pow;
        int remain = n - high * pow;
        if (high == 1) {
            return helper(pow - 1) + remain + 1 + helper(remain);
        } else {
            return pow + high * helper(pow - 1) + helper(remain);
        }
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Solution().countDigitOne(n));
    }
}