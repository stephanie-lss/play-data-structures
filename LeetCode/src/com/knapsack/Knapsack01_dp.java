package com.knapsack;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/7 12:34
 */
public class Knapsack01_dp {

    int knapsack01(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][capacity + 1];
        Arrays.fill(dp, -1);
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = (j >= weight[0] ? value[0] : 0);
        }
        for (int i = 1; i < n; i++) {
                for (int j = 0; j <= capacity; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[n - 1][capacity];
    }
}
