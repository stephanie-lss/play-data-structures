package com.array.medium.solution300;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/26 13:35
 */
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //状态：1种
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = dp[1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution2().lengthOfLIS(nums));
    }
}
