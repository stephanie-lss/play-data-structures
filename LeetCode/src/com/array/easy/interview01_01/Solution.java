package com.array.easy.interview01_01;

/**
 * @author LiSheng
 * @date 2020/4/1 14:39
 */
public class Solution {
    public boolean isUnique(String astr) {
        int[] freq = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int c = astr.charAt(i) - 'a';
            freq[c]++;
            if (freq[c] == 2) {
                return false;
            }
        }
        return true;
    }
}
