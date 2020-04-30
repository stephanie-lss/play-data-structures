package com.top100.solution64;

/**
 * @author LiSheng
 * @date 2020/4/28 16:58
 */
class Solution2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        //状态：二维矩阵的行列
        //base case
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    grid[i][j] += (i == 0 ? 0 : grid[i - 1][j]);
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution2().minPathSum(grid));
    }
}