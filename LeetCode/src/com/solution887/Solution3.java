package com.solution887;

/**
 * @author LiSheng
 * @date 2020/4/11 10:36
 */
public class Solution3 {
    int[][] memo;

    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (memo[K][N] == 0) {
            int ans;
            if (N == 0) {
                return 0;
            } else if (K == 1) {
                return N;
            } else {
                int low = 1, high = N;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int t1 = dp(K - 1, mid - 1);
                    int t2 = dp(K - 1, N - mid);
                    if (t1 < t2) {
                        low = mid;
                    } else if (t1 > t2) {
                        high = mid;
                    } else {
                        low = high = mid;
                    }
                }
                ans = 1 + Math.min(Math.max(dp(K - 1, low - 1), dp(K - 1, N - low)), Math.max(dp(K - 1, N - high), dp(K - 1, high - 1)));
            }
            memo[K][N] = ans;
        }
        return memo[K][N];
    }
}
