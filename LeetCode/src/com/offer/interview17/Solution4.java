package com.offer.interview17;

/**
 * @author LiSheng
 * @date 2020/6/2 9:29
 */
public class Solution4 {
    public int[] printNumbers(int n) {
        int end = quickPow(10, n);
        int[] res = new int[end];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    private int quickPow(int x, int n) {
        int res = 1, tmp = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        return res;
    }
}
