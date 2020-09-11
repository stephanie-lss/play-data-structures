package com.offer.interview04;

/**
 * @author LiSheng
 * @date 2020/5/23 12:33
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int[] start = {0, matrix[0].length - 1};

        while (true) {
            if (matrix[start[0]][start[1]] == target) {
                return true;
            } else if (matrix[start[0]][start[1]] < target) {
                //往下
                start[0]++;
            } else {
                //往左
                start[1]--;
            }
            if (start[1] < 0 || start[0] == matrix.length) {
                return false;
            }
        }
    }
}