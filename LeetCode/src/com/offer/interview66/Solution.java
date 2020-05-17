package com.offer.interview66;

/**
 * @author LiSheng
 * @date 2020/5/16 16:58
 */
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length, tmp = 1;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp *= a[i - 1];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = n - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] arr = new Solution().constructArr(a);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}