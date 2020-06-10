package com.offer.interview43;

/**
 * @author LiSheng
 * @date 2020/6/10 10:15
 */
public class Solution2 {
    public int countDigitOne(int n) {
        return helper(n);

    }

    private int helper(int n) {
        if (n <= 0) {
            return 0;
        }
        int pow = 1, num = 0;
        while (num <= n) {
            num = (int) Math.pow(10, pow++);
        }
        int first = n / pow;
        int remain = n - first * pow;
        if (first == 1) {
            return remain + 1 + countDigitOne(pow - 1) + countDigitOne(remain);
        } else {
            return first * countDigitOne(pow - 1) + countDigitOne(remain) + pow;
        }
    }
}
