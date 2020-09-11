package com.top100.solution62;

/**
 * @author LiSheng
 * @date 2020/4/30 17:42
 */
class Solution {
    public int uniquePaths(int m, int n) {
        //状态：两个——行数，列数
        //dp[i][j]表示从左上角到第i行，第j列时的路径数
        int[][] dp = new int[n][m];
        //base case
        //只有一行，路径就一条
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        //只有一列，路径就一条
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}