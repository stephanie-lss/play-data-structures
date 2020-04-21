package com.dp.linear.solution53;

/**
 * @author LiSheng
 * @date 2020/4/21 14:03ko
 * 优化空间复杂度
 */
class Solution2 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = dp < 0 ? nums[i] : dp + nums[i];
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution2().maxSubArray(nums));
    }
}