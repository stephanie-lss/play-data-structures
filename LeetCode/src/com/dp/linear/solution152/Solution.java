package com.dp.linear.solution152;

/**
 * @author LiSheng
 * @date 2020/4/21 18:08
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //dp[i][0]表示以nums[i-1]结尾时对应的最小值
        //dp[i][1]表示以nums[i-1]结尾时对应的最大值
        int[][] dp = new int[n + 1][2];
        //base case
        dp[1][0] = nums[0];
        dp[1][1] = nums[0];
        int max = dp[1][0];
        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] < 0) {
                int tmp = dp[i - 1][0];
                dp[i - 1][0] = dp[i - 1][1];
                dp[i - 1][1] = tmp;
            }
            dp[i][0] = Math.min(dp[i - 1][0] * nums[i - 1], nums[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1] * nums[i - 1], nums[i - 1]);
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}
