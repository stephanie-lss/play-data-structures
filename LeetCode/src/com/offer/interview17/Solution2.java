package com.offer.interview17;

/**
 * @author LiSheng
 * @date 2020/5/11 20:40
 */
class Solution2 {
    public int[] printNumbers(int n) {
        int end = power(10, n);
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    private int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int tmp = power(x, n / 2);
        return (n & 1) == 1 ? tmp * tmp * x : tmp * tmp;
    }
}
