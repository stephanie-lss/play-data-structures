package com.solution887;

/**
 * @author LiSheng
 * @date 2020/4/11 10:36
 */
public class Solution2 {
    int[][] dp;

    public int superEggDrop(int K, int N) {
        dp = new int[K + 1][N + 1];
        int M = 0;
        while (dp[M][K] < N) {
            M++;
            for (int i = 1; i <= K; i++) {
                dp[M][i] = dp[M - 1][i - 1] + dp[M - 1][i] + 1;
            }
        }
        return M;
    }
}
