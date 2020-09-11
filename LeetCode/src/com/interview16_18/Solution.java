package com.interview16_18;

/**
 * @author LiSheng
 * @date 2020/6/22 14:33
 */
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        return dfs(new String[2], pattern, 0, value, 0);
    }

    private boolean dfs(String[] str, String pattern, int p, String value, int v) {
        if (p == pattern.length() && v == value.length()) {
            return true;
        } else if (p >= pattern.length() || v > value.length()) {
            return false;
        }
        int index = pattern.charAt(p) - 'a';
        if (str[index] == null) {
            for (int i = v; i <= value.length(); i++) {
                str[index] = value.substring(v, i);
                if ((str[index] == null || str[index ^ 1] == null || !str[index].equals(str[index ^ 1])) && dfs(str, pattern, p + 1, value, i)) {
                    return true;
                }
            }
            str[index] = null;
            return false;
        } else {
            int end = str[index].length() + v;
            if (end > value.length() || !value.substring(v, end).equals(str[index])) {
                return false;
            }
            return dfs(str, pattern, p + 1, value, end);
        }
    }

    public static void main(String[] args) {
        String pat = "abba";
        String val = "dogcatcatfish";
        System.out.println(new Solution().patternMatching(pat, val));
    }
}
