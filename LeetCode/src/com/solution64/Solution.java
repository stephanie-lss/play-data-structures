package com.solution64;

/**
 * @author LiSheng
 * @date 2020/7/23 8:52
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new RuntimeException();
        }
        int m = grid.length, n = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i-1][j-1]时路径最小和
        //base case
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}
