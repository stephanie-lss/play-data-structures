package com.offer.interview20;

/**
 * @author LiSheng
 * @date 2020/6/20 15:55
 */
public class Solution2 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean haveNum = false, haveDot = false, haveEe = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                haveNum = true;
            } else if (c == '.') {
                if (haveDot || haveEe || i == 0) {
                    return false;
                }
                haveDot = true;
            } else if (c == 'e' || c == 'E') {
                if (haveEe || !haveNum) {
                    return false;
                }
                haveNum = false;
                haveEe = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isNumber(" 005047e+6"));
    }
}
