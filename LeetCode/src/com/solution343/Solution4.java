package com.solution343;

/**
 * @author LiSheng
 * @date 2020/7/30 9:05
 */
public class Solution4 {
    public int integerBreak(int n) {
        //dp[i]表示绳子长度为i时能获得的最大成绩
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().integerBreak(10));
    }
}
