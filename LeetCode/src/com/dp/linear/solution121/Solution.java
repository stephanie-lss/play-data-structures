package com.dp.linear.solution121;

/**
 * @author LiSheng
 * @date 2020/4/22 11:04
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}