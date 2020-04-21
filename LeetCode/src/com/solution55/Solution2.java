package com.solution55;

/**
 * @author LiSheng
 * @date 2020/4/17 9:40
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1]) {
                for (int j = 0; j < nums[i - 1]; j++) {
                    if (j + i >= nums.length) {
                        return true;
                    }
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        System.out.println(new Solution2().canJump(nums));
    }
}