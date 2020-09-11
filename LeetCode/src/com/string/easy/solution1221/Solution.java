package com.string.easy.solution1221;

/**
 * @author LiSheng
 * @date 2020/4/5 22:26
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int t = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                ++t;
            } else {
                --t;
            }
            if (t == 0) {
                count++;
            }
        }
        return count;
    }
}
