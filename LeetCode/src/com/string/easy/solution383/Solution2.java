package com.string.easy.solution383;

/**
 * @author LiSheng
 * @date 2020/4/2 14:43
 */
public class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] record = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = magazine.indexOf(ransomNote.charAt(i), record[ransomNote.charAt(i) - 'a']);
            if (index == -1) {
                return false;
            }
            record[ransomNote.charAt(i) - 'a'] = index + 1;
        }
        return true;
    }
}
