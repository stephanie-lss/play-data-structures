package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0,2);
        list.add(1,3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            quickSort(a, left, p - 1);
            quickSort(a, p + 1, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int s = a[left];
        int p = left + 1;
        for (int i = p; i <= right; i++) {
            if (a[i] < s) {
                int tmp = a[i];
                a[i] = a[p];
                a[p++] = tmp;
            }
        }
        int t = a[p - 1];
        a[p - 1] = a[left];
        a[left] = t;
        return p - 1;
    }

}