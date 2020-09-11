package com.dp.linear.solution188;

/**
 * @author LiSheng
 * @date 2020/4/22 16:14
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k > n / 2) {
            return maxProfit(prices, n);
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 >= 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                } else {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                }
            }
        }
        return dp[n - 1][k][0];
    }

    private int maxProfit(int[] prices, int n) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            } else {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }
        }
        return dp[n - 1][0];
    }
}
