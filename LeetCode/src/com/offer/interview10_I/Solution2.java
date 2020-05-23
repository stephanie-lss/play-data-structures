package com.offer.interview10_I;

/**
 * @author LiSheng
 * @date 2020/5/23 15:26
 */
public class Solution2 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000_000_007;
        }
        return dp[n];
    }
}
