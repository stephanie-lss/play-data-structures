package com.string.medium.solution8;

/**
 * @author LiSheng
 * @date 2020/4/3 17:11
 */
public class Solution {
    public int myAtoi(String str) {
        boolean flag = false;
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-' || c == '+') {
                if (i == 0) {
                    flag = true;
                    sb.append(c);
                } else {
                    if (flag && i == 1) {
                        return 0;
                    } else {
                        break;
                    }
                }
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }
        if (sb.toString().length() == 0) {
            return 0;
        }
        if (flag && sb.toString().length() == 1) {
            return 0;
        }
        if (Double.valueOf(sb.toString()) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (Double.valueOf(sb.toString()) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("20000000000000000000"));
    }
}
