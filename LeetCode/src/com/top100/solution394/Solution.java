package com.top100.solution394;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/5/2 16:17
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    Character topC = stack.pop();
                    sb.append(topC);
                }
                String string = sb.toString();
                stack.pop();
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());
                sb = new StringBuilder();
                while (count-- != 0) {
                    sb.append(string);
                }
                String s1 = sb.toString();
                for (int i = s1.length() - 1; i >= 0; i--) {
                    stack.push(s1.charAt(i));
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
        System.out.println(new Solution().decodeString("100[leetcode]"));
    }
}