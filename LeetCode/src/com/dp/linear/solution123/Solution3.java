package com.dp.linear.solution123;

/**
 * @author LiSheng
 * @date 2020/4/22 13:40
 */
class Solution3 {
    public int maxProfit(int[] prices) {
        int k = 2;
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
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

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}