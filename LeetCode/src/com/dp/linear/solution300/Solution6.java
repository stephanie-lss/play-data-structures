package com.dp.linear.solution300;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/1 9:23
 */
public class Solution6 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //dp[i]表示nums中的以nums[i-1]结尾的最长上升子序列长度
        int[] dp = new int[n + 1];
        //base case
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 2, 5, 7, 2, 5, 6, 5, 9, 1, 3, 7, 101, 18};
        System.out.println(new Solution6().lengthOfLIS(nums));
    }
}
