package com.string.medium.solution791;

/**
 * @author LiSheng
 * @date 2020/4/13 12:44
 */
public class Solution {
    public String customSortString(String S, String T) {
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        int[] tFreq = new int[26];
        for (char c : tChars) {
            tFreq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char sChar : sChars) {
            if (tFreq[sChar - 'a'] != 0) {
                for (int i = 0; i < tFreq[sChar - 'a']; i++) {
                    sb.append(sChar);
                }
            }
            tFreq[sChar - 'a'] = 0;
        }
        for (int i = 0; i < tFreq.length; i++) {
            if (tFreq[i] != 0) {
                for (int j = 0; j < tFreq[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }
}
