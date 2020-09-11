package com.string.easy.solution680;

/**
 * @author LiSheng
 * @date 2020/5/19 8:55
 */
class Solution2 {
    private boolean flag = true;

    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return isPalindrome(s, left + 1, right - 1);
        } else {
            if (flag) {
                flag = false;
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            } else {
                return flag;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abcda";
        System.out.println(new Solution2().validPalindrome(str));
    }
}