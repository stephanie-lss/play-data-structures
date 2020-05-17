package com.offer.interview14_I;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/17 17:07
 */
class Solution {

    int[] memo;

    public int cuttingRope(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return cutHelper(n);
    }

    private int cutHelper(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(i * cutHelper(n - i), i * (n - i)), res);
        }
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}