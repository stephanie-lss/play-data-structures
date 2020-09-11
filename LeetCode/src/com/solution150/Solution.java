package com.solution150;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/25 10:29
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!"+".equals(tokens[i]) && !"-".equals(tokens[i]) && !"*".equals(tokens[i]) && !"/".equals(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(String.valueOf(Integer.valueOf(s2) + Integer.valueOf(s1)));
                        break;
                    case "-":
                        stack.push(String.valueOf(Integer.valueOf(s2) - Integer.valueOf(s1)));
                        break;
                    case "*":
                        stack.push(String.valueOf(Integer.valueOf(s2) * Integer.valueOf(s1)));
                        break;
                    case "/":
                        stack.push(String.valueOf(Integer.valueOf(s2) / Integer.valueOf(s1)));
                        break;
                    default:
                        throw new IllegalArgumentException("Error");
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] nums = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(nums));
    }
}
