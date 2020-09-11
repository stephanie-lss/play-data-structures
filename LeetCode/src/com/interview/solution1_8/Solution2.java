package com.interview.solution1_8;

/**
 * @author LiSheng
 * @date 2020/6/23 16:15
 */
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        boolean clearRow = false, clearCol = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        clearCol = true;
                    }
                    if (j == 0) {
                        clearRow = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                //该列需要清零
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                //该行需要清零
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (clearCol) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (clearRow) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 3}};
        new Solution2().setZeroes(mat);
    }
}
