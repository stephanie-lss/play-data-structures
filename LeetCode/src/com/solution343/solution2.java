package com.solution343;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/2/28 10:37
 */
public class solution2 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (int i = 2; i <= n - 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max(dp[i], j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    private int max(int n1, int n2, int n3) {
        return Math.max(Math.max(n1, n2), n3);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
