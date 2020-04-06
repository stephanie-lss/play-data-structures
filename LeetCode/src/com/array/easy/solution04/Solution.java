package com.array.easy.solution04;

/**
 * @author LiSheng
 * @date 2020/4/1 15:55
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix.length == 1 && matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            if (binary(matrix[i], 0, n - 1, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binary(int[] arr, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = right - (right - left) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binary(arr, left, mid - 1, target);
        } else {
            return binary(arr, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{}};
        new Solution().findNumberIn2DArray(matrix, 1);
    }
}
