package com.solution125;

/**
 * @author LiSheng
 * @date 2020/6/19 8:41
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && (!Character.isDigit(s.charAt(left)) && !Character.isLetter(s.charAt(left)))) {
                left++;
            }

            while (left < right && (!Character.isDigit(s.charAt(right)) && !Character.isLetter(s.charAt(right)))) {
                right--;
            }

            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(new Solution().isPalindrome(s));
    }
}
