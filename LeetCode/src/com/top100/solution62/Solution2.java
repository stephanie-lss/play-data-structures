package com.top100.solution62;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/30 17:42
 */
class Solution2 {
    public int uniquePaths(int m, int n) {
        //状态：两个——行数，列数
        //dp[i][j]表示从左上角到第i行，第j列时的路径数
        int[] dp = new int[m];
        //base case
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(7, 3));
    }
}