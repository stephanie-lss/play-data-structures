package com.solution84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LiSheng
 * @date 2020/5/5 10:56
 */
public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, newHeights.length - 2);
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < newHeights.length; i++) {
            //找到了右边界
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                Integer cur = stack.poll();
                res = Math.max(res, (i - stack.peek() - 1) * newHeights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new Solution3().largestRectangleArea(heights));
    }
}
