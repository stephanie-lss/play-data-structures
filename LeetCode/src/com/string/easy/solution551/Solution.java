package com.string.easy.solution551;

/**
 * @author LiSheng
 * @date 2020/4/3 22:25
 */
public class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('A' == s.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else if ('L' == s.charAt(i)) {
                if (i != s.length() - 1 && i != 0) {
                    if (s.charAt(i - 1) == 'L' && s.charAt(i + 1) == 'L') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
