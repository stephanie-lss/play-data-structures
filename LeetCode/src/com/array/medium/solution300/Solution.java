package com.array.medium.solution300;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/26 13:35
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //状态：1种
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = dp[1];
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
