package com.solution887;

/**
 * @author LiSheng
 * @date 2020/4/11 10:36
 */
public class Solution {
    int[][] dp;

    public int superEggDrop(int K, int N) {
        dp = new int[K + 1][N + 1];
        return helper(K, N);
    }

    private int helper(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (dp[k][n] != 0) {
            return dp[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, 1 + Math.max(helper(k - 1, i - 1), helper(k, n - i)));
        }
        dp[k][n] = res;
        return res;
    }
}
