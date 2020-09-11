package com.offer.interview42;

/**
 * @author LiSheng
 * @date 2020/7/15 10:25
 */
public class Solution4 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length, max = 0;
        //dp[i]表示以nums[i-1]结尾的最大值
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            max = Math.max(max, dp[i] = dp[i - 1] <= 0 ? nums[i - 1] : dp[i - 1] + nums[i - 1]);
        }
        return max;
    }
}
