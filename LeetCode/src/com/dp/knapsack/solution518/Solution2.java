package com.dp.knapsack.solution518;

/**
 * @author LiSheng
 * @date 2020/4/24 13:47
 */
class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]表示使用前i个硬币凑成金额j的方案个数
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}