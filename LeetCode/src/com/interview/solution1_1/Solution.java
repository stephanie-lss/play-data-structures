package com.interview.solution1_1;

/**
 * @author LiSheng
 * @date 2020/6/23 10:33
 */
class Solution {
    public boolean isUnique(String astr) {
        if (astr.length() == 0) {
            return true;
        }
        int[] alp = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int c = astr.charAt(i) - 'a';
            if (alp[c] != 0) {
                return false;
            } else {
                alp[c]++;
            }
        }
        return true;
    }
}