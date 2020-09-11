package com.dp.linear.solution887;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/24 18:23
 */
public class Solution {
    private int[][] memo;

    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[K][N] != -1) {
            return memo[K][N];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        memo[K][N] = res;
        return res;
    }
}
