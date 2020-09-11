package com.solution45;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/4 10:00
 * NOT AC
 */
class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 3, 1, 1, 1};
        System.out.println(new Solution2().jump(nums));
    }
}