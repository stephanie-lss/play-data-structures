package com.dp.classical.solution354;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/27 14:59
 */
class Solution2 {
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
        //状态：两种——二维数组中的区间
        //dp[i][j]:envelopes[i-1,j-1]中所能组成一组“俄罗斯套娃”信封的个数
        int[][] dp = new int[n + 1][n + 1];
        //base case:每一个信封都能单独组成一个“俄罗斯套娃”信封
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 1);
        }
        int res = 1;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = i; k < j; k++) {
                    if (envelopes[j - 1][0] > envelopes[k - 1][0] && envelopes[j - 1][1] > envelopes[k - 1][1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + 1);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] env = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        System.out.println(new Solution2().maxEnvelopes(env));
    }
}