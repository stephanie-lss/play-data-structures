package com.array.easy.solution1122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 12:10
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for (int i : arr2) {
            max = Math.max(max, i);
        }
        int[] count = new int[max + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    count[arr1[j]]++;
                    arr1[j] = -1;
                }
            }
        }
        for (int i : arr1) {
            if (i!=-1){
                list.add(i);
            }
        }
        Collections.sort(list);
        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < count.length; j++) {
                while (count[i]-- > 0) {
                    arr1[idx++] = i;
                }
            }
        }
        for (Integer i : list) {
            arr1[idx++] = i;
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(new Solution().relativeSortArray(arr1, arr2));
    }
}