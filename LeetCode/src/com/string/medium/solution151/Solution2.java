package com.string.medium.solution151;

/**
 * @author LiSheng
 * @date 2020/4/10 9:39
 */
public class Solution2 {
    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return "";
        }
        int right = -1;
        int left = -1;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                if (flag) {
                    right = i;
                    flag = false;
                }
                left = i;
            } else {
                if (!flag) {
                    for (int j = left; j <= right; j++) {
                        sb.append(chars[j]);
                    }
                    sb.append(" ");
                    flag = true;
                }
            }
        }
        for (int j = left; j <= right; j++) {
            sb.append(chars[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverseWords("   ab good   example  "));
    }
}