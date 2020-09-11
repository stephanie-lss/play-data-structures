package com.dp.linear.solution198;

/**
 * @author LiSheng
 * @date 2020/4/21 20:19
 */
class Solution4 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i], nums[i]));
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution4().rob(nums));
    }
}