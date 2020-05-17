package com.offer.interview40;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/16 15:25
 */
public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int l, int r, int k) {
        int p = partition(arr, l, r);
        if (p == k) {
            return Arrays.copyOf(arr, p + 1);
        }
        return p > k ? quickSearch(arr, l, p - 1, k) : quickSearch(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        int low = arr[l];
        int i = l;
        for (int j = i + 1; j <= r; j++) {
            if (arr[j] < low && i++ != j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[l];
        arr[l] = tmp;
        return i;
    }
}