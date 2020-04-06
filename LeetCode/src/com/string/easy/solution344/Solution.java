package com.string.easy.solution344;

/**
 * @author LiSheng
 * @date 2020/4/2 14:30
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
