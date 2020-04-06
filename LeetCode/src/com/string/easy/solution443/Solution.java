package com.string.easy.solution443;

/**
 * @author LiSheng
 * @date 2020/4/3 19:05
 */
public class Solution {
    public int compress(char[] chars) {
        int cur = 0, j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[j++] = chars[cur];
                if (i > cur) {
                    for (char c : ("" + (i - cur + 1)).toCharArray()) {
                        chars[j++] = c;
                    }
                }
                cur = i + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b'};
        System.out.println(new Solution().compress(chars));
    }
}
