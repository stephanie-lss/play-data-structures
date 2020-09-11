package com.solution84;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/30 13:22
 */
public class Solution5 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, newHeights.length - 2);
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.getLast()] > newHeights[i]) {
                int p = stack.removeLast();
                max = Math.max(max, newHeights[p] * (i - stack.getLast() - 1));
            }
            stack.addLast(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hei = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution5().largestRectangleArea(hei));
    }
}
