package com.top100.solution394;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/5/2 16:17
 */
class Solution2 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c != ']') {
                stack.push(c + "");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!"[".equals(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String string = sb.toString();
                stack.pop();
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());
                while (count-- != 0) {
                    stack.push(string);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().decodeString("100[leetcode]"));
    }
}