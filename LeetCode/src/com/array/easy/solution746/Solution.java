package com.array.easy.solution746;

/**
 * @author LiSheng
 * @date 2020/3/30 15:16
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]表示到第i个楼梯时的最小花费
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[cost.length - 1];
    }
}
