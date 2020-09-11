package com.interview.solution8_11;

/**
 * @author LiSheng
 * @date 2020/4/23 9:43
 */
public class Solution3 {

    int[] money = {1, 5, 10, 25};

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= money[i]) {
                    dp[j] = (dp[j] + dp[j - money[i]]) % 1000_000_007;
                }
            }
        }
        return dp[n];
    }
}
