package com.offer.interview10_II;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/22 14:48
 */
class Solution {
    private int[] memo;

    public int numWays(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return jump(n);
    }

    private int jump(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        memo[n] = (jump(n - 1) + jump(n - 2)) % 1000_000_007;
        return memo[n];
    }

    public static void main(String[] args) {
        int num = 44;
        System.out.println(new Solution().numWays(num));
    }
}