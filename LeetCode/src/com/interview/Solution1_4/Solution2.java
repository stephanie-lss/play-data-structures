package com.interview.Solution1_4;

/**
 * @author LiSheng
 * @date 2020/6/23 14:42
 */
public class Solution2 {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        int[] record = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if ((record[s.charAt(i)]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
