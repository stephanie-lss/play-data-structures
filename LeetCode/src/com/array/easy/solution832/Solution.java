package com.array.easy.solution832;

/**
 * @author LiSheng
 * @date 2020/3/29 19:31
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] ^= 1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            flip(A[i]);
        }
        return A;
    }

    private void flip(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;
            head++;
            tail--;
        }
    }
}
