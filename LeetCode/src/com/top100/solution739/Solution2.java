package com.top100.solution739;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/30 17:30
 */
class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] TT = {73, 74, 75, 71, 69, 72, 76, 73};
        new Solution2().dailyTemperatures(TT);
    }
}
