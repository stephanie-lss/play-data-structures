package com.top100.solution301;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/4 19:04
 */
class Solution3 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        boolean exist = false;
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            if (isValid(curStr)) {
                res.add(curStr);
                exist = true;
            }
            if (exist) {
                continue;
            }
            for (int i = 0; i < curStr.length(); i++) {
                if (curStr.charAt(i) != '(' && curStr.charAt(i) != ')') {
                    continue;
                }
                String str = curStr.substring(0, i) + curStr.substring(i + 1);
                if (!set.contains(str)) {
                    queue.offer(str);
                    set.add(str);
                }
            }
        }
        return res;
    }

    private boolean isValid(String str) {
        int left = 0, right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left <= right) {
                    return false;
                }
                right++;
            }
        }
        return left == right;
    }

    public static void main(String[] args) {
        String str = "(a)())()";
        List<String> res = new Solution3().removeInvalidParentheses(str);
        res.forEach(System.out::println);
    }
}
