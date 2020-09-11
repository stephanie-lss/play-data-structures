package com.array.easy.solution1287;

/**
 * @author LiSheng
 * @date 2020/3/31 12:36
 */
public class Solution2 {
    public int findSpecialInteger(int[] arr) {
        int size = arr.length / 4;
        for (int i = 0; i < arr.length - size; i++) {
            if (arr[i] == arr[i + size]) {
                return arr[i];
            }
        }
        return arr[arr.length - size];
    }
}
