package com.interview.solution1_2;

/**
 * @author LiSheng
 * @date 2020/6/23 10:51
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] a1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (a1[s2.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                a1[s2.charAt(i) - 'a']--;
            }
        }
        for (int i : a1) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
