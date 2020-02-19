package com.solution3;

/**
 * @author LiSheng
 * @date 2020/2/18 11:14
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1;
        int[] freq = new int[256];
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
