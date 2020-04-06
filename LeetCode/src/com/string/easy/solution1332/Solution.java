package com.string.easy.solution1332;

/**
 * @author LiSheng
 * @date 2020/4/5 23:10
 */
public class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (isPalindromic(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindromic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
