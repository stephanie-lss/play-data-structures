package com.interview.solution1_7;

/**
 * @author LiSheng
 * @date 2020/6/23 15:44
 */
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //1、按列翻转
        for (int i = 0; i < len; i++) {
            int top = 0, bot = len - 1;
            while (top < bot) {
                int tmp = matrix[top][i];
                matrix[top][i] = matrix[bot][i];
                matrix[bot][i] = tmp;
                top++;
                bot--;
            }
        }
        //2、按对角线进行翻转
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}