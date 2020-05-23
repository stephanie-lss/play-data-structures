package com.offer.interview10_I;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/23 15:22
 */
public class Solution {
    private int[] memo;

    public int fib(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        memo[n] = (helper(n - 1) + helper(n - 2)) % 100_000_0007;
        return memo[n];
    }
}
