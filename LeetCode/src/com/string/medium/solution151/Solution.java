package com.string.medium.solution151;

/**
 * @author LiSheng
 * @date 2020/4/10 9:39
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!"".equals(strings[i])) {
                sb.append(strings[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}