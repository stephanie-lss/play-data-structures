package com.array.medium.interview01_07;

/**
 * @author LiSheng
 * @date 2020/4/7 9:46
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = matrix[n - j - 1][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
