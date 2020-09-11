package com.solution242;

/**
 * @author LiSheng
 * @date 2020/2/19 12:24
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (t.length() != n) {
            return false;
        }
        int[] freq = new int[26];
        //O(n)
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 97]++;
            freq[t.charAt(i) - 97]--;
        }
        //O(n)
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 97] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Solution2().isAnagram("rat", "car");
        System.out.println(flag);
    }
}
