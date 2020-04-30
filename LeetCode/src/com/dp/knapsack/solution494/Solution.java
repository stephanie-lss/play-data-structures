package com.dp.knapsack.solution494;

/**
 * @author LiSheng
 * @date 2020/4/23 16:25
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j + nums[i] < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
                if (j - nums[i] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}