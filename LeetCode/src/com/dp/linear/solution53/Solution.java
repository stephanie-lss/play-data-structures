package com.dp.linear.solution53;

/**
 * @author LiSheng
 * @date 2020/4/21 14:03
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(new Solution().maxSubArray(nums));
    }
}