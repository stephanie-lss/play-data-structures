package com.offer.interview63;

/**
 * @author LiSheng
 * @date 2020/6/19 9:47
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution2().maxProfit(prices));
    }
}
