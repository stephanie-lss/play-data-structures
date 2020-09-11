package com.offer.interview67;

/**
 * @author LiSheng
 * @date 2020/5/24 18:41
 */
public class Solution2 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        int stop = Integer.MAX_VALUE / 10, sign = 1, res = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            if (res > stop || res == stop && c > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c - '0';
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        String str = "  0000000000012345678";
        String str2 = "20000000000000000000";
        String str3 = "-2";
        String str4 = " ";
        String str5 = " -1010023630o4";
        String str6 = "  0000000000012345678";
        String str7 = "  0000000000012345678";
        System.out.println(new Solution2().strToInt(str));
        System.out.println(new Solution2().strToInt(str2));
        System.out.println(new Solution2().strToInt(str3));
        System.out.println(new Solution2().strToInt(str4));
        System.out.println(new Solution2().strToInt(str5));
        System.out.println(new Solution2().strToInt(str6));
        System.out.println(new Solution2().strToInt(str7));
    }
}
