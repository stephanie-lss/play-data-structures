package com.top100.solution221;

/**
 * @author LiSheng
 * @date 2020/5/7 21:22
 */
class Solution3 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] mat = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1'}};
        System.out.println(new Solution3().maximalSquare(mat));
    }
}