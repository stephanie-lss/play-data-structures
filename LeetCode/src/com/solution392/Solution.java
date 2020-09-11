package com.solution392;

/**
 * @author LiSheng
 * @date 2020/7/27 8:39
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int endS = s.length(), endT = t.length();
        int leftS = 0, leftT = 0;
        while (leftS < endS && leftT < endT) {
            if (s.charAt(leftS) == t.charAt(leftT++)) {
                leftS++;
            }
        }
        return leftS == endS;
    }

    public static void main(String[] args) {
        String str = "abc";
        String ttr = "ahbgdc";
        System.out.println(new Solution().isSubsequence(str, ttr));
    }
}
