package com.string.medium.solution394;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/5/28 9:25
 */
public class Solution2 {

    public String decodeString(String s) {
        Stack<Integer> mutStack = new Stack<>();
        Stack<String> res = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int mut = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                mut = mut * 10 + (c - '0');
            } else if (c == '[') {
                mutStack.push(mut);
                res.push(sb.toString());
                mut = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer pop = mutStack.pop();
                for (int j = 0; j < pop; j++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(res.pop() + tmp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "3[a2[c]]";
        System.out.println(new Solution2().decodeString(str));
    }
}
