package com.dp.linear.solution120;

import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/20 15:05
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(row - 1).size(); i++) {
            min = Math.min(min, dp[row - 1][i]);
        }
        return min;
    }
}
