package com.array.medium.solution1162;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/29 12:30
 */
public class Solution2 {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 101);
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i + 1 < row) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < col) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        int res = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        if (res == 101 || res == 0) {
            return -1;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new Solution2().maxDistance(grid));
    }
}
