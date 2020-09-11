package com.string.medium.solution5;

/**
 * @author LiSheng
 * @date 2020/4/26 17:31
 */

class Solution {
    public String longestPalindrome(String s) {
        String res = s.length() == 0 ? "" : String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if ((s.length() & 1) == 1) {
                //字符串为奇数
                int length = longestStr(s, i, i);
                if (length > res.length()) {
                    res = s.substring(i - length / 2, i + length / 2 + 1);
                }
            } else {
                //字符串为偶数
                int length = longestStr(s, i, i + 1);
                if (length > res.length()) {
                    res = s.substring(i - (length - 2) / 2, i + 1 + length / 2);
                }
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
        String str = "abb";
        System.out.println(new Solution().longestPalindrome(str));
    }
}
