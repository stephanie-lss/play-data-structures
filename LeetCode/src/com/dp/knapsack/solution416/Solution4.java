package com.dp.knapsack.solution416;

/**
 * @author LiSheng
 * @date 2020/4/23 20:26
 */
class Solution4 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果数组总和为奇数，不可能分割
        if ((sum & 1) == 1) {
            return false;
        }

        int t = sum >>> 1;

        boolean[][] dp = new boolean[n + 1][t + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][t];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new Solution4().canPartition(nums));
    }
}