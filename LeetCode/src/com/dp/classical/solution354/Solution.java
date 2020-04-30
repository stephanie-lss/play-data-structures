package com.dp.classical.solution354;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/27 13:17
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o2[1] - o1[1];
            }
        });

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (envelopes[i - 1][1] > envelopes[j - 1][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] env = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        System.out.println(new Solution().maxEnvelopes(env));
    }
}
