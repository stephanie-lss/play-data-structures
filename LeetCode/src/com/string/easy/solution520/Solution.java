package com.string.easy.solution520;

/**
 * @author LiSheng
 * @date 2020/4/3 21:21
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (i > 0 && (c >= 'A' && c <= 'Z')) {
                if (word.charAt(i - 1) >= 'a' && word.charAt(i - 1) <= 'z') {
                    return false;
                }
                if (i != word.length() - 1) {
                    if (word.charAt(i + 1) >= 'a' && word.charAt(i + 1) <= 'z') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("ee"));
    }
}
