package com.array.easy.solution746;

/**
 * @author LiSheng
 * @date 2020/3/30 15:16
 */
public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
