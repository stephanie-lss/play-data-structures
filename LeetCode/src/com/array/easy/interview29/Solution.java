package com.array.easy.interview29;

/**
 * @author LiSheng
 * @date 2020/4/1 16:14
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int idx = 0;
        while (true) {
            //从左向右走
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右向左走
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().spiralOrder(mat);
    }
}
