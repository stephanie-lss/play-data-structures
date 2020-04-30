package com.string.medium.solution5;

/**
 * @author LiSheng
 * @date 2020/4/26 17:31
 */

class Solution2 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int length = longestStr(s, i, i);
            if (length > res.length()) {
                res = s.substring(i - length / 2, i + length / 2 + 1);
            }
            length = longestStr(s, i, i + 1);
            if (length > res.length()) {
                res = s.substring(i - (length - 2) / 2, i + 1 + length / 2);
            }
        }
        return res;
    }

    private int longestStr(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(new Solution2().longestPalindrome(str));
    }
}
