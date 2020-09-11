package com.array.easy.solution1299;

/**
 * @author LiSheng
 * @date 2020/3/31 13:24
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], arr[i + 1]);
        }
        return res;
    }
}
