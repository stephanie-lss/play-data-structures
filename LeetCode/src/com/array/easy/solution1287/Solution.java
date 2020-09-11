package com.array.easy.solution1287;

/**
 * @author LiSheng
 * @date 2020/3/31 12:36
 */
public class Solution {
    public int findSpecialInteger(int[] arr) {
        int[] count = new int[100001];
        int n = arr.length;
        double shold = n * 0.25;
        for (int i : arr) {
            count[i]++;
            if (count[i] > shold) {
                return i;
            }
        }
        throw null;
    }
}
