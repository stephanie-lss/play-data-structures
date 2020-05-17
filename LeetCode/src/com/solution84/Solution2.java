package com.solution84;

/**
 * @author LiSheng
 * @date 2020/5/5 10:32
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    private int helper(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }
        int min = left;
        for (int i = left + 1; i <= right; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }
        return Math.max((right - left + 1) * heights[min], Math.max(helper(heights, left, min - 1), helper(heights, min + 1, right)));
    }
}
