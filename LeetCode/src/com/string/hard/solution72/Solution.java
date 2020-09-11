package com.string.hard.solution72;

/**
 * @author LiSheng
 * @date 2020/4/6 9:47
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        //dp[i][j]表示word1的前i个字母转换成word2的前j个字母所需要的最小次数
        //dp[i-1][j]：表示进行了一次删操作
        //dp[i][j-1]:表示进行一次增操作
        //dp[i-1][j-1]:表示进行了一次替换操作
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    private int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }
}
