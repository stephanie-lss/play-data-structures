package com.offer.interview58_I;

/**
 * @author LiSheng
 * @date 2020/5/23 10:20
 */
class Solution2 {
    public String reverseWords(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() != 0) {
                if ("".equals(res.toString())) {
                    res = new StringBuilder(sb.toString());
                } else {
                    res.insert(0, sb.toString() + " ");
                }
                sb = new StringBuilder();
            }
        }
        String str1 = sb.toString();
        String str2 = res.toString();
        if ("".equals(str2)) {
            return str1;
        } else {
            return str1 + " " + str2;
        }
    }
}