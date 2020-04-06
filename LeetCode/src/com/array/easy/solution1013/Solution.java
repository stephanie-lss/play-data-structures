package com.array.easy.solution1013;

/**
 * @author LiSheng
 * @date 2020/3/28 15:48
 */
public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int head = 1;
        int tail = A.length - 2;
        int sumH = A[0];
        int sumT = A[A.length - 1];
        while (head <= tail) {
            if (sumH == sum / 3 && sumT == sum / 3) {
                return true;
            }
            if (sumH != sum / 3) {
                sumH += A[head];
                head++;
            }
            if (sumT != sum / 3) {
                sumT += A[tail];
                tail--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {18, 12, -18, 18, -19, -1, 10, 10};
        System.out.println(new Solution().canThreePartsEqualSum(A));
    }
}
