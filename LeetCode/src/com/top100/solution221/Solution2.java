package com.top100.solution221;

/**
 * @author LiSheng
 * @date 2020/5/7 21:22
 */
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] - 48 == 1) {
                    dp[i][j] = 1;
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] += Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] mat = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1'}};
        System.out.println(new Solution2().maximalSquare(mat));
    }
}