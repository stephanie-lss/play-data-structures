package com.offer.interview42;

/**
 * @author LiSheng
 * @date 2020/6/8 11:10
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = -100;
        //dp[i]表示数组以nums[i-1]结尾的最大值和
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] <= 0 ? nums[i - 1] : dp[i - 1] + nums[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
