package com.solution63;

/**
 * @author LiSheng
 * @date 2020/7/6 20:10
 */
public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = 0;
        if (null == obstacleGrid || (row = obstacleGrid.length) == 0) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        //dp[i][j]表示从[0][0]到[i][j]总共有多少条路径
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
