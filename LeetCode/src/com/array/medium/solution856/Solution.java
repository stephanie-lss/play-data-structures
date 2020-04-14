package com.array.medium.solution856;

/**
 * @author LiSheng
 * @date 2020/4/14 13:27
 */
public class Solution {
    public int scoreOfParentheses(String S) {
        int deep = 0, res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                deep++;
            } else {
                deep--;
                if (S.charAt(i - 1) == '(') {
                    res = res + (1 << deep);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "(()(()))";
        System.out.println(new Solution().scoreOfParentheses(S));
    }
}
