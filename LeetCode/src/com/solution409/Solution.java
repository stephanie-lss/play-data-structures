package com.solution409;

/**
 * @author LiSheng
 * @date 2020/3/19 9:09
 */
class Solution {
    public int longestPalindrome(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] freq = new int[100];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'A']++;
        }
        int res = 0;
        for (int i = 0; i < freq.length; i++) {
            res += freq[i] / 2 * 2;
            if (freq[i] % 2 != 0 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
    }
}
