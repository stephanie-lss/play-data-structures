package com.top100.solution301;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/3 20:33
 */
class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        int leftDeleteC = 0, rightDeleteC = 0, leftCountC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftDeleteC++;
            } else if (s.charAt(i) == ')') {
                if (leftDeleteC > 0) {
                    leftDeleteC--;
                } else {
                    rightDeleteC++;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        dfs(s, leftDeleteC, rightDeleteC, leftCountC, 0, new StringBuilder(), set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int leftDeleteC, int rightDeleteC, int leftCountC, int index, StringBuilder sb, HashSet<String> set) {
        if (index == s.length()) {
            if (leftDeleteC == 0 && rightDeleteC == 0 && leftCountC == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            if (leftDeleteC > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, leftDeleteC - 1, rightDeleteC, leftCountC, index + 1, tmp, set);
            }
            //不删除，或者leftDeletetC已经<=0
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, leftDeleteC, rightDeleteC, leftCountC + 1, index + 1, tmp, set);
        } else if (c == ')') {
            //删除
            if (rightDeleteC > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, leftDeleteC, rightDeleteC - 1, leftCountC, index + 1, tmp, set);
            }
            //不删除或者rightDeleteC <=0
            if (leftCountC > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(c);
                dfs(s, leftDeleteC, rightDeleteC, leftCountC - 1, index + 1, tmp, set);
            }else {
                //leftCountC<=0并且此时c为右括号，因此为无效字符串直接返回
                return;
            }
            //不添加
        } else {
            //普通字符
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, leftDeleteC, rightDeleteC, leftCountC, index + 1, tmp, set);
        }
    }

    public static void main(String[] args) {
        String str = "()())()";
        List<String> list = new Solution2().removeInvalidParentheses(str);
        list.forEach(System.out::println);
    }
}