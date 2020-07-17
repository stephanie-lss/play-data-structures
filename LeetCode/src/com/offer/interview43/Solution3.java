package com.offer.interview43;

/**
 * @author LiSheng
 * @date 2020/7/15 10:40
 */
public class Solution3 {
    public int countDigitOne(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int pow = (int) Math.pow(10, s.length() - 1);
        int high = s.charAt(0) - '0';
        int remain = n - high * pow;
        if (high == 1) {
            return helper(pow - 1) + helper(remain) + remain + 1;
        } else {
            return helper(pow - 1) * high + helper(remain) + pow;
        }
    }
}
