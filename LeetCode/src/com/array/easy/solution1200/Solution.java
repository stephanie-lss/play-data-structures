package com.array.easy.solution1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 17:24
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (min == arr[i + 1] - arr[i]) {
                res.add(new ArrayList<>(Arrays.asList(new Integer[]{arr[i], arr[i + 1]})));
            }
        }
        return res;
    }
}
