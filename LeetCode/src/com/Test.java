package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test {
    public static void main(String[] args) {
        int[] a = {4, 3, 51, 7, 2, 11};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
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