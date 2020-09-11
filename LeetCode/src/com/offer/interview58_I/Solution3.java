package com.offer.interview58_I;

/**
 * @author LiSheng
 * @date 2020/6/16 10:20
 */
public class Solution3 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            } else {
                while (s.charAt(i) == ' ') {
                    i++;
                }
                sb.append(" ");
                res.insert(0, sb);
                sb = new StringBuilder();
            }
        }
        sb.append(" ");
        res.insert(0, sb);
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(new Solution3().reverseWords(str));
    }
}
