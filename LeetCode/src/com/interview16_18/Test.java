package com.interview16_18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/22 14:58
 */
public class Test {
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        //统计max的位数
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int j = 0; j < array.length; j++) {
            int mod = array[j] % 10;
            bucketList.get(mod).add(array[j]);
        }
        for (int i = 1; i < maxDigit; i++) {
            for (List<Integer> bucket : bucketList) {
                int size = bucket.size();
                while (size-- != 0) {
                    int mod = bucket.get(0) / (int) Math.pow(10, i) % 10;
                    bucketList.get(mod).add(bucket.remove(0));
                }
            }
        }
        int idx = 0;
        for (List<Integer> list : bucketList) {
            for (int num : list) {
                array[idx++] = num;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        //bubbleSort(a, a.length);
        //selectSort(a, a.length);
        //insertSort(a, a.length);
        //shellSort(a, a.length);
        //mergeSort(a, 0, a.length - 1);
        //mergeSortNR(a, a.length);
        //quickSort(a, 0, a.length - 1);
        //heapSort(a, a.length);
        //countingSort(a);
        a = radixSort(a);
        for (int n : a) {
            System.out.print(n + " ");
        }
    }
}
