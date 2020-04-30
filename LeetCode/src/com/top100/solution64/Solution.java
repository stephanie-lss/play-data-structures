package com.top100.solution64;

/**
 * @author LiSheng
 * @date 2020/4/28 16:58
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        //状态：二维矩阵的行列
        int[][] dp = new int[m + 1][n + 1];
        //base case
        dp[1][1] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}