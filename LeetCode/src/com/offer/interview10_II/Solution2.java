package com.offer.interview10_II;

/**
 * @author LiSheng
 * @date 2020/5/22 14:57
 */
public class Solution2 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(new Solution2().numWays(n));
    }
}
