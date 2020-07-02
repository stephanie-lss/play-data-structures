package com.solution718;

/**
 * @author LiSheng
 * @date 2020/7/1 8:37
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[A.length + 1][B.length + 1];
        //dp[i][j]表示以A[i - 1]，B[j - 1]时数组中的公共最长字符数长度
        dp[0][0] = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}