package com.offer.interview66;

/**
 * @author LiSheng
 * @date 2020/6/19 10:25
 */
public class Solution2 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        int tmp = 1;
        res[0] = tmp;
        for (int i = 1; i < len; i++) {
            tmp *= a[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = len - 2; i > 1; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
