package com.solution84;

/**
 * @author LiSheng
 * @date 2020/5/30 13:02
 */
public class Solution4 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int p1 = i;
            while (--p1 >= 0 && heights[i] <= heights[p1]) { }
            int p2 = i;
            while (++p2 < heights.length && heights[i] <= heights[p2]) { }
            max = Math.max(max, (p2 - p1 - 1) * heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hei = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution4().largestRectangleArea(hei));
    }
}
