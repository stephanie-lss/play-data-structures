package com.offer.interview58_I;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/23 10:20
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() != 0) {
                stack.addLast(sb.toString());
                sb = new StringBuilder();
            }
        }
        stack.addLast(sb.toString());
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}