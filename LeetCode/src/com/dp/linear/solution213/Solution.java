package com.dp.linear.solution213;

/**
 * @author LiSheng
 * @date 2020/4/21 21:11
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] + nums[i] : nums[i]));
        }

        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return dp[nums.length - 2] > dp2[nums.length - 1] ? dp[nums.length - 2] : dp2[nums.length - 1];
    }
}