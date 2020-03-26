package com.interview17_16;

/**
 * @author LiSheng
 * @date 2020/3/24 10:29
 */
public class Solution3 {
    int[] dp;

    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(new Solution3().massage(nums2));
    }
}
