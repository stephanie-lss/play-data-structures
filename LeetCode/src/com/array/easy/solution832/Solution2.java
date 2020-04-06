package com.array.easy.solution832;

/**
 * @author LiSheng
 * @date 2020/3/29 19:31
 */
public class Solution2 {
    public int[][] flipAndInvertImage(int[][] A) {
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
            nums[head] = nums[tail] ^ 1;
            nums[tail] = tmp ^ 1;
            head++;
            tail--;
        }
        if (head == tail) {
            nums[head] ^= 1;
        }
    }
}
