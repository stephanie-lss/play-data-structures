package com.solution322;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/8 11:21
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution().coinChange(coins, 11));
    }
}
