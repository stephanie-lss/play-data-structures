package com.string.easy.solution383;

/**
 * @author LiSheng
 * @date 2020/4/2 14:43
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            freq[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (freq[magazine.charAt(i) - 'a'] != 0) {
                freq[magazine.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (freq[ransomNote.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
}
