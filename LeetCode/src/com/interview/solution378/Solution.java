package com.interview.solution378;

/**
 * @author LiSheng
 * @date 2020/7/2 9:02
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = 0, right = n - 1;
        int[] sortArray = mergeMatrix(matrix, left, right);
        return sortArray[k - 1];
    }

    private  int[] mergeMatrix(int[][] matrix, int left, int right) {
        if (left >= right) {
            return matrix[left];
        }
        int mid = left + (right - left) / 2;
        int[] l1 = mergeMatrix(matrix, left, mid);
        int[] l2 = mergeMatrix(matrix, mid + 1, right);
        return merge(l1, l2);
    }

    private int[] merge(int[] l1, int[] l2) {
        int[] ret = new int[l1.length + l2.length];
        int idx1 = 0, idx2 = 0, idx = 0;
        while (idx1 < l1.length && idx2 < l2.length) {
            if (l1[idx1] <= l2[idx2]) {
                ret[idx++] = l1[idx1++];
            } else {
                ret[idx++] = l2[idx2++];
            }
        }
        while (idx1 < l1.length) {
            ret[idx++] = l1[idx1++];
        }
        while (idx2 < l2.length) {
            ret[idx++] = l2[idx2++];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution().kthSmallest(mat, 8));
    }
}