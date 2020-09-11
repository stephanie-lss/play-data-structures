package com.dp.knapsack.solution322;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/23 18:19
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0) {
            return -1;
        }
        //使用前n个硬币凑成amount金额所需的最小硬币数
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, amount + 1);
        }
        //base case
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    //放
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        System.out.println(new Solution2().coinChange(coins, amount));
    }
}
