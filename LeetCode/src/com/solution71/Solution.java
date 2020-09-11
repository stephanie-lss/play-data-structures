package com.solution71;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/25 10:56
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/asdasd/.asds"));
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}
