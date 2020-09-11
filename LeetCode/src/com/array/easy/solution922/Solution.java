package com.array.easy.solution922;

/**
 * @author LiSheng
 * @date 2020/3/30 22:18
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                //偶数
                ret[even] = A[i];
                even += 2;
            } else {
                //奇数
                ret[odd] = A[i];
                odd += 2;
            }
        }
        return ret;
    }
}
