package com.array.easy.solution867;

/**
 * @author LiSheng
 * @date 2020/3/27 20:00
 */
public class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int line = A[0].length;
        int[][] res = new int[line][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
