package com.offer.interview40;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/14 10:34
 */
public class Solution4 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[]{};
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        int p = partition(arr, left, right);
        if (p == k) {
            return Arrays.copyOfRange(arr, 0, p);
        }
        return p > k ? quickSort(arr, left, p - 1, k) : quickSort(arr, p + 1, right, k);
    }

    private int partition(int[] arr, int left, int right) {
        int ref = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < ref && j++ != i) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] numbers = new Solution4().getLeastNumbers(arr, 2);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
