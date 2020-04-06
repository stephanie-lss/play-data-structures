package com.string.easy.solution917;

/**
 * @author LiSheng
 * @date 2020/4/5 13:12
 */
public class Solution2 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left++] ^= chars[right--];
            } else if (!Character.isLetter(chars[left])) {
                left++;
            } else {
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
