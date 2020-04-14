package com.array.medium.solution856;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/14 13:27
 */
public class Solution2 {
    public int scoreOfParentheses(String S) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                Integer p1 = stack.pop();
                Integer p2 = stack.pop();
                stack.push(p2 + Math.max(2 * p1, 1));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String S = "(()(()))";
        System.out.println(new Solution2().scoreOfParentheses(S));
    }
}
