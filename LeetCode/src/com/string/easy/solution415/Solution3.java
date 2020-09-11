package com.string.easy.solution415;

/**
 * @author LiSheng
 * @date 2020/4/2 17:59
 */
public class Solution3 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().addStrings("184","18"));
    }
}
