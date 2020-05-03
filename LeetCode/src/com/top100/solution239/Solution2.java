package com.top100.solution239;

/**
 * @author LiSheng
 * @date 2020/5/3 17:31
 */
class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int right = k - 1;
        int[] dp = new int[nums.length - right];
        for (int i = 0; i < k; i++) {
            dp[0] = Math.max(dp[0], nums[i]);
        }
        int p = k;
        for (int i = 1; i < dp.length; i++, p++) {
            if (nums[i - 1] == dp[i - 1]) {
                //删除的刚好之最大
                //需要重新找到最大值
                dp[i] = nums[i];
                for (int j = i + 1; j <= p; j++) {
                    dp[i] = Math.max(dp[i], nums[j]);
                }
            } else {
                //删除的不是最大值
                dp[i] = dp[i - 1] > nums[p] ? dp[i - 1] : nums[p];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(new Solution2().maxSlidingWindow(nums, k));
    }
}
