package com.offer.interview40;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/6/8 9:56
 */
public class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quick(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quick(int[] arr, int l, int r, int k) {
        int p = partion(arr, l, r);
        if (p == k) {
            return Arrays.copyOfRange(arr, 0, p + 1);
        }
        return p > k ? quick(arr, l, p - 1, k) : quick(arr, p + 1, r, k);
    }

    private int partion(int[] arr, int left, int right) {
        int p = arr[left];
        int low = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= p && low++ != i) {
                int tmp = arr[i];
                arr[i] = arr[low];
                arr[low] = tmp;
            }
        }
        int tmp = arr[low];
        arr[low] = arr[left];
        arr[left] = tmp;
        return low;
    }
}
