package com.top100.solution240;

/**
 * @author LiSheng
 * @date 2020/4/30 13:55
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] > target) {
                n--;
            } else if (matrix[m][n] < target) {
                m++;
            } else if (matrix[m][n] == target) {
                return true;
            }
        }
        return false;
    }
}
