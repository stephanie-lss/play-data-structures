package com.string.easy.solution709;

/**
 * @author LiSheng
 * @date 2020/4/4 17:33
 */
public class Solution {
    public String toLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                str = str.replace(c, (char) (c + 32));
            }
        }
        return str;
    }
}
