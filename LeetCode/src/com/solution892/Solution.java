package com.solution892;

/**
 * @author LiSheng
 * @date 2020/3/25 10:37
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        int line = grid[0].length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0) {
                    sum += j != 0 ? grid[i][j] * 6 - (grid[i][j] - 1) * 2 - (Math.min(grid[i][j], grid[i][j - 1])) * 2 : grid[i][j] * 6 - (grid[i][j] - 1) * 2;
                } else {
                    sum += j != 0 ? grid[i][j] * 6 - (grid[i][j] - 1) * 2 - (Math.min(grid[i][j], grid[i][j - 1])) * 2 - (Math.min(grid[i][j], grid[i - 1][j])) * 2 : grid[i][j] * 6 - (grid[i][j] - 1) * 2 - (Math.min(grid[i][j], grid[i - 1][j])) * 2;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        int[][] grid2 = {{1, 0}, {0, 2}};
        System.out.println(new Solution().surfaceArea(grid));
        System.out.println(new Solution().surfaceArea(grid2));
    }
}