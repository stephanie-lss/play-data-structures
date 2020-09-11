package com.dp.knapsack.solution518;

/**
 * @author LiSheng
 * @date 2020/4/24 13:47
 */
class Solution {
    public int change(int amount, int[] coins) {
        //dp[i]表示使用硬币凑成金额i的方案个数
        int[] dp = new int[amount + 1];
        //base case
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}