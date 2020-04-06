package com.array.easy.solution888;

/**
 * @author LiSheng
 * @date 2020/3/27 20:05
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sum2 += B[i];
        }

        int r = (sum1 + sum2) / 2;

        int[] res = new int[2];

        if (sum1 > sum2) {
            for (int i = A.length - 1; i >= 0; i--) {
                for (int j = 0; j < B.length; j++) {
                    if (sum1 - A[i] + B[j] == r) {
                        res[0] = A[i];
                        res[1] = B[j];
                    }
                }
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                for (int j = B.length - 1; j >= 0; j--) {
                    if (sum1 - A[i] + B[j] == r) {
                        res[0] = A[i];
                        res[1] = B[j];
                    }
                }
            }
        }
        return res;
    }
}
