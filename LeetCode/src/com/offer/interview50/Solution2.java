package com.offer.interview50;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/15 21:24
 */
public class Solution2 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 || chars[i - 1] != chars[i]) && chars[i] != chars[i + 1]) {
                return chars[i];
            }
        }
        return ' ';
    }
}
