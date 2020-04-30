package com.dp.linear.solution72;

/**
 * @author LiSheng
 * @date 2020/4/26 17:04
 */
class Solution2 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        //状态：word1，word2
        //dp[i][j]表示word1中间的前i个字符转换成word2中的前j个字符所使用的最少操作数
        int[][] dp = new int[n1 + 1][n2 + 1];
        //base case
        //表示当word2为空时，要经历i步插入操作
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        //表示当word1为空时，要经历i步插入操作
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min3(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
    private int min3(int t1, int t2, int t3) {
        return Math.min(Math.min(t1, t2), t3);
    }
}