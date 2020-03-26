package com.solution945;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/22 14:47
 */
class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                A[i + 1]++;
                count++;
            } else if (A[i] > A[i + 1]) {
                int tmp = A[i + 1];
                A[i + 1] = A[i] + 1;
                count += A[i + 1] - tmp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        System.out.println(new Solution().minIncrementForUnique(A));
    }
}
