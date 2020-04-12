package com.math.easy.solution171;

/**
 * @author LiSheng
 * @date 2020/4/8 12:02
 */
public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += s.charAt(i) * Math.pow(26, s.length() - 1 - i);
        }
        return sum;
    }
}
