package com.array.easy.solution566;

/**
 * @author LiSheng
 * @date 2020/3/29 19:12
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //原数组的行数
        int m = nums.length;
        //列数
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int index = 0;
        int[] tmp = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[index++] = nums[i][j];
            }
        }
        index = 0;
        int[][] newArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArr[i][j] = tmp[index++];
            }
        }
        return newArr;
    }
}
