package com.offer.interview20;

/**
 * @author LiSheng
 * @date 2020/5/25 14:30
 */
class Solution {
    public boolean isNumber(String s) {
        boolean dot = false, aE = false, aNum = false;
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (Character.isDigit(strs[i])) {
                aNum = true;
            } else if (strs[i] == '+' || strs[i] == '-') {
                //+-号只能出现在第一个位置或者e的后面
                if (i != 0 && strs[i - 1] != 'e' && strs[i - 1] != 'E') {
                    return false;
                }
            } else if (strs[i] == '.') {
                //.之前不能出现.和e
                if (dot || aE) {
                    return false;
                }
                dot = true;
            } else if (strs[i] == 'e' || strs[i] == 'E') {
                //e之前不能出现e，并且e之前必须有数字.e2 e2 +.e1等都是不是数字
                if (aE || !aNum) {
                    return false;
                }
                aE = true;
                //为了防止最后一位出现e儿返回true，比如1e这种情况
                aNum = false;
            } else {
                return false;
            }
        }
        return aNum;
    }

    public static void main(String[] args) {
        String s1 = "+.";
        String s2 = "1.1e2";
        String s3 = "e2";
        String s4 = ".e2";
        String s5 = "+.e2";
        String s6 = "+.8e1";
        String s7 = "+.8";
        String s8 = "-.8";
        String s9 = ".3";
        String s10 = "+.3";
        String s11 = "+-.3";
        String s12 = "+-3";
        String s13 = "-1E-16";
        String s14 = "12e+5.4";
        System.out.println(new Solution().isNumber(s1));
        System.out.println(new Solution().isNumber(s2));
        System.out.println(new Solution().isNumber(s3));
        System.out.println(new Solution().isNumber(s4));
        System.out.println(new Solution().isNumber(s5));
        System.out.println(new Solution().isNumber(s6));
        System.out.println(new Solution().isNumber(s7));
        System.out.println(new Solution().isNumber(s8));
        System.out.println(new Solution().isNumber(s9));
        System.out.println(new Solution().isNumber(s10));
        System.out.println(new Solution().isNumber(s11));
        System.out.println(new Solution().isNumber(s12));
        System.out.println(new Solution().isNumber(s13));
        System.out.println(new Solution().isNumber(s14));
    }
}