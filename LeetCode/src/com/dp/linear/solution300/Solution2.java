package com.dp.linear.solution300;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/20 10:34
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution2().lengthOfLIS(a));
    }
}
