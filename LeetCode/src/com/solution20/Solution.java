package com.solution20;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2019/12/30 17:24
 * @Title 有效的括号
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("["));
        System.out.println(solution.isValid("]"));
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("{{"));
        System.out.println(solution.isValid("}}"));
        System.out.println(solution.isValid("[]}"));
    }

    public boolean isValid(String s) {
        if (s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top!='{' && c=='}') {
                    return false;
                }
                if (top!='[' && c==']') {
                    return false;
                }
                if (top!='(' && c==')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
