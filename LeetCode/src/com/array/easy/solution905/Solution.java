package com.array.easy.solution905;

/**
 * @author LiSheng
 * @date 2020/3/30 0:27
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] newA = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                newA[left++] = A[i];
            } else {
                newA[right--] = A[i];
            }
        }
        return newA;
    }
}
