package com.top100.solution279;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/1 12:22
 */
class Solution3 {
    public int numSquares(int n) {
        //dp[i]表示组成数字i时的最少完全平方数的个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //base case
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
