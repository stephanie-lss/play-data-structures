package com.array.easy.solution1394;

/**
 * @author LiSheng
 * @date 2020/4/1 14:25
 */
public class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 500; i > 0; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
