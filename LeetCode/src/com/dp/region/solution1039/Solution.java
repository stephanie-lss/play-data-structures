package com.dp.region.solution1039;

/**
 * @author LiSheng
 * @date 2020/4/23 14:08
 */
class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + A[l] * A[k] * A[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}