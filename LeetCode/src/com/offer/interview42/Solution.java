package com.offer.interview42;

/**
 * @author LiSheng
 * @date 2020/5/15 20:27
 */
class Solution {
    public int maxSubArray(int[] nums) {
        //dp[i]表示以nums[i-1]结尾时连续子数组最大值
        int dp = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            dp = dp > 0 ? dp + nums[i - 1] : nums[i - 1];
            max = Math.max(dp, max);
        }
        return max;
    }
}