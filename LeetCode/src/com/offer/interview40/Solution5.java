package com.offer.interview40;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/30 9:44
 */
public class Solution5 {
    private int[] res;

    public int[] getLeastNumbers(int[] arr, int k) {
        int n = 0;
        if (arr == null || (n = arr.length) == 0 || k <= 0) {
            return null;
        }
        this.res = new int[k];
        quickSort(arr, k, 0, n - 1);
        return res;
    }

    private void quickSort(int[] arr, int k, int low, int high) {
        if (low > high) {
            return;
        }
        int p = partition(arr, low, high);
        if (p == k - 1) {
            res = Arrays.copyOfRange(arr, 0, k);
        } else if (p < k - 1) {
            quickSort(arr, k, p + 1, high);
        } else {
            quickSort(arr, k, low, p - 1);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int ref = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < ref && j++ != i) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] numbers = new Solution5().getLeastNumbers(arr, 2);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
