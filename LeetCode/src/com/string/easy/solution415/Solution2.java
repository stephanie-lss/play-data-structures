package com.string.easy.solution415;

/**
 * @author LiSheng
 * @date 2020/4/2 15:06
 */
public class Solution2 {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int tt = 0;
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || tt!=0) {
            int t1 = 0;
            if (n1 >= 0) {
                t1 = num1.charAt(n1--) - 48;
            }
            int t2 = 0;
            if (n2 >= 0) {
                t2 = num2.charAt(n2--) - 48;
            }
            tmp = (t1 + t2) + tt;
            tt = 0;
            if (tmp >= 10) {
                sb.append(tmp % 10);
                tt = tmp / 10;
            } else {
                sb.append(tmp);
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().addStrings("999", "999"));
    }
}