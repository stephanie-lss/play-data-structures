package com.top100.solution85;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/5 11:55
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] heights = new int[column];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            res = Math.max(res, largestRectangle(heights));
        }
        return res;
    }

    private int largestRectangle(int[] height) {
        int[] newHeight = new int[height.length + 2];
        int ret = 0;
        System.arraycopy(height, 0, newHeight, 1, newHeight.length - 2);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                Integer cur = stack.pop();
                ret = Math.max(ret, newHeight[cur] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][] mat = {{'0','1'}, {'1', '0'}};
        System.out.println(new Solution().maximalRectangle(mat));
    }
}