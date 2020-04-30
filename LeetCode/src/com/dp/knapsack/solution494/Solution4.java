package com.dp.knapsack.solution494;

/**
 * @author LiSheng
 * @date 2020/4/23 18:05
 */
class Solution4 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j + nums[i - 1] < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + S];
    }
}