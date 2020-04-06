package com.array.easy.solution766;

/**
 * @author LiSheng
 * @date 2020/3/29 22:47
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{18}, {66}};
        System.out.println(new Solution().isToeplitzMatrix(mat));
    }
}