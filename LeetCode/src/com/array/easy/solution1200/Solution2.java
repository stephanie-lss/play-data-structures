package com.array.easy.solution1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 17:24
 */
public class Solution2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                res.add(Arrays.asList(new Integer[]{arr[i], arr[i + 1]}));
            } else if (arr[i + 1] - arr[i] < min) {
                res.clear();
                res.add(Arrays.asList(new Integer[]{arr[i], arr[i + 1]}));
                min = arr[i + 1] - arr[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 10, 15};
        new Solution2().minimumAbsDifference(arr);
    }
}
