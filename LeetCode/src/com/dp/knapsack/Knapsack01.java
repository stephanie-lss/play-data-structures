package com.dp.knapsack;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/7 12:34
 */
public class Knapsack01 {

    private int[][] dp;

    int knapsack01(int[] weight, int[] value, int capacity) {
        dp = new int[capacity + 1][weight.length];
        Arrays.fill(dp, -1);
        int index = weight.length - 1;
        return bestValue(weight, value, capacity, index);
    }

    private int bestValue(int[] weight, int[] value, int c, int index) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (dp[c][index] != -1) {
            return dp[c][index];
        }
        int res = bestValue(weight, value, c, index - 1);
        if (c - weight[index] >= 0) {
            res = Math.max(res, value[index] + bestValue(weight, value, c - weight[index], index - 1));
        }
        dp[c][index] = res;
        return res;
    }
}
