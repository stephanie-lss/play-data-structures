package com.array.easy.solution922;

/**
 * @author LiSheng
 * @date 2020/3/30 22:18
 */
class Solution2 {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        for (even = 0; even < A.length; even += 2) {
            if (A[even] % 2 == 1) {
                while (A[odd] % 2 == 1) {
                    odd += 2;
                }
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
            }
        }
        return A;
    }
}
