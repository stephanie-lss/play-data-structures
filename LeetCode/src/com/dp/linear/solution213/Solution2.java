package com.dp.linear.solution213;

/**
 * @author LiSheng
 * @date 2020/4/21 21:11
 */
class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(getMax(nums, 0, nums.length - 1), getMax(nums, 1, nums.length));
    }

    private int getMax(int[] nums, int start, int end) {
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        for (int i = start + 1; i < end; i++) {
            dp[i - start] = Math.max(dp[i - 1 - start], (i - 2 - start >= 0 ? dp[i - 2 - start] + nums[i] : nums[i]));
        }
        return dp[end - start - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 9, 2};
        System.out.println(new Solution2().rob(nums));
    }
}