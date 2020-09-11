package com.top100.solution238;

/**
 * @author LiSheng
 * @date 2020/4/28 15:00
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{0};
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i - 1] * dp[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] *= tmp;
            tmp *= nums[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new Solution().productExceptSelf(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
