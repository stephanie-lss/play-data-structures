package com.dp.knapsack.solution416;

/**
 * @author LiSheng
 * @date 2020/4/23 14:21
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int end = sum / 2;
        boolean[][] dp = new boolean[nums.length][end + 1];

        dp[0][0] = true;
        if (nums[0] == end) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == end) {
                return true;
            }
            for (int j = 0; j <= end; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][end];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new Solution().canPartition(nums));
    }
}