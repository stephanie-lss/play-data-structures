package com.offer.interview20;

/**
 * @author LiSheng
 * @date 2020/7/7 19:53
 */
public class Solution3 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean num = false, dot = false, eE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == ',') {
                if (dot || eE || i == 0) {
                    return false;
                }
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (eE || !num) {
                    return false;
                }
                eE = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return num;
    }
}
