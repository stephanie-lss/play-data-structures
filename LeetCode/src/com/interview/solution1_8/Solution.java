package com.interview.solution1_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/23 16:02
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        for (int[] zero : zeros) {
            for (int i = 0; i < col; i++) {
                matrix[zero[0]][i] = 0;
            }
            for (int i = 0; i < row; i++) {
                matrix[i][zero[1]] = 0;
            }
        }
    }
}