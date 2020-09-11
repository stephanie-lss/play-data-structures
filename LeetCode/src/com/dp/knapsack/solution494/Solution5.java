package com.dp.knapsack.solution494;

/**
 * @author LiSheng
 * @date 2020/4/23 21:24
 */
class Solution5 {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S) {
            return 0;
        }
        int[][] dp = new int[n + 1][sum + sum + 1];
        //前0个物品可以构成目标数0的方案为1,sum只是偏移量
        dp[0][sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * sum; j++) {
                if (j + nums[i - 1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][2 * sum];
    }
}