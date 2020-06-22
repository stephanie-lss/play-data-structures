package com.offer.interview67;

/**
 * @author LiSheng
 * @date 2020/6/20 14:40
 */
public class Solution3 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean sign = true;
        if (str.charAt(0) == '-') {
            //第一位是-
            sign = false;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            //第一位是+
            str = str.substring(1);
        }
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (res > max || (res == max && c > '7')) {
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    res = res * 10 + (c - '0');
                }
            } else {
                break;
            }
        }
        return sign ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().strToInt("-2147483645"));
        System.out.println(new Solution3().strToInt("    -42"));
        System.out.println(new Solution3().strToInt("4193 with words"));
        System.out.println(new Solution3().strToInt("words and 987"));
        System.out.println(new Solution3().strToInt("-91283472332"));
        System.out.println(new Solution3().strToInt(" -1010023630o4"));
        System.out.println(new Solution3().strToInt("+1"));
        System.out.println(new Solution3().strToInt("    0000000000000   "));
        System.out.println(new Solution3().strToInt("  0000000000012345678"));
        System.out.println(new Solution3().strToInt("+-2"));
        System.out.println(new Solution3().strToInt("20000000000000000000"));
    }
}
