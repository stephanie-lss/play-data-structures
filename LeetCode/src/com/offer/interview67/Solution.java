package com.offer.interview67;

/**
 * @author LiSheng
 * @date 2020/5/24 16:48
 */
class Solution {
    //MAX:2147483647
    //MIN:-2147483648
    public int strToInt(String str) {
        if ("".equals(str)) {
            return 0;
        }
        int p = 0;
        //plus=0表示没有正负号，plus=1表示带正号，plus=-1表示带负号
        int plus = 0;
        //1、去除开头的空格
        while (p < str.length() && str.charAt(p) == ' ') {
            p++;
        }
        if (p == str.length()) {
            return 0;
        }
        //2、开始进行转换
        char first = str.charAt(p);
        if (first == '-') {
            plus = -1;
            p++;
        } else if (first == '+') {
            plus = 1;
            p++;
        }
        //case1:第一个字符是英文字符，直接返回0
        if (!Character.isDigit(first) && plus != -1 && plus != 1) {
            return 0;
        }

        return strToIntHelper(str.substring(p), plus);
    }

    private int strToIntHelper(String str, int plus) {
        StringBuilder sb = new StringBuilder();
        if ("".equals(str)) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return returnFun(plus, sb);
            } else {
                sb.append(c);
            }
        }
        return returnFun(plus, sb);
    }

    private int returnFun(int plus, StringBuilder sb) {
        while (sb.length()!=0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return 0;
        }
        if (sb.length() > 10) {
            if (plus == -1) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        Long aLong = Long.valueOf(sb.toString());
        if (plus == -1) {
            sb.insert(0, "-");
            return -aLong < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.valueOf(sb.toString());
        } else {
            return aLong > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.valueOf(sb.toString());
        }
    }

    public static void main(String[] args) {
        String str = "    0000000000000   ";
        System.out.println(new Solution().strToInt(str));
    }
}