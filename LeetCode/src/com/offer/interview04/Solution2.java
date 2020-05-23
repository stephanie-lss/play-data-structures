package com.offer.interview04;

/**
 * @author LiSheng
 * @date 2020/5/23 12:41
 */
public class Solution2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (binarSearchLine(matrix, target, 0, matrix.length)) {
            return true;
        }
        return false;
    }

    private boolean binarSearchLine(int[][] matrix, int target, int left, int right) {
        if (left >= right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (matrix[mid][0] == target) {
            return true;
        } else if (matrix[mid][0] > target) {
            return binarSearchLine(matrix, target, left, mid);
        } else {
            if (binarySearch(matrix[mid], 0, matrix[0].length - 1, target)) {
                return true;
            }
            if (mid + 1 < matrix.length && matrix[mid + 1][0] > target) {
                return binarSearchLine(matrix, target, left, mid);
            }
            return binarSearchLine(matrix, target, left, mid) || binarSearchLine(matrix, target, mid + 1, right);
        }
    }

    private boolean binarySearch(int[] line, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (line[mid] == target) {
            return true;
        } else if (line[mid] > target) {
            return binarySearch(line, left, mid - 1, target);
        } else {
            return binarySearch(line, mid + 1, right, target);
        }
    }
}
