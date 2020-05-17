package com.offer.interview17;

/**
 * @author LiSheng
 * @date 2020/5/11 20:32
 */
class Solution {
    public int[] printNumbers(int n) {
        int end = 1;
        int tmp = 10;
        while (n != 0) {
            if ((n & 1) == 1) {
                end *= tmp;
            }
            tmp *= tmp;
            n >>= 1;
        }
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}