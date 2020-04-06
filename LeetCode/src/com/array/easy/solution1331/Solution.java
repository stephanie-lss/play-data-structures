package com.array.easy.solution1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/3/31 13:57
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        Map<Integer, Integer> record = new HashMap<>();
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!record.containsKey(arr[i])) {
                record.put(arr[i], count++);
            } else {
                record.put(arr[i], count - 1);
            }
        }
        for (int i = 0; i < copy.length; i++) {
            arr[i] = record.get(copy[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        new Solution().arrayRankTransform(arr);
    }
}
