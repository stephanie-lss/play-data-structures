package com.math.easy.solution883;

/**
 * @author LiSheng
 * @date 2020/4/10 10:38
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int area = m * n;
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
                if (grid[i][j] == 0){
                    area--;
                }
            }
            area += max;
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            area += max;
        }
        return area;
    }
}
