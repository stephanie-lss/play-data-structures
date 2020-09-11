package com.array.easy.solution1051;

/**
 * @author LiSheng
 * @date 2020/3/31 11:07
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            min = Math.min(min, height);
            max = Math.max(max, height);
        }
        int[] count = new int[max - min + 1];
        for (int height : heights) {
            count[height - min]++;
        }
        int res = 0;
        int idx = 0;
        for (int i = min; i <= max; i++) {
            int cnt = count[i - min];
            while (cnt-- > 0) {
                if (heights[idx++] != i) {
                    res++;
                }
            }
        }
        return res;
    }
}
