package com.dp.knapsack.solution322;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/23 18:19
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < n; i++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
