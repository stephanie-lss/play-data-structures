package com.dp.linear.solution309;

/**
 * @author LiSheng
 * @date 2020/4/22 16:48
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], (i - 2 >= 0 ? dp[i - 2][0] - prices[i] : -prices[i]));
            } else if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }
        }
        return dp[prices.length - 1][0];
    }
}