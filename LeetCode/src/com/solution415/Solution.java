package com.solution415;

/**
 * @author LiSheng
 * @date 2020/8/3 8:51
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int p = num1.length() - 1, q = num2.length() - 1, mut = 0;
        while (p >= 0 && q >= 0) {
            int i = num1.charAt(p--) - '0';
            int j = num2.charAt(q--) - '0';
            sb.insert(0, (i + j + mut) % 10);
            mut = (i + j + mut) / 10;
        }
        helper(num1, sb, mut, p);
        helper(num2, sb, mut, q);
        return mut == 0 ? sb.toString() : sb.insert(0, mut).toString();
    }

    private void helper(String num, StringBuilder sb, int mut, int idx) {
        while (idx >= 0) {
            if (mut == 0) {
                sb.insert(0, num.substring(0, idx + 1));
                break;
            } else {
                int i = num.charAt(idx--) - '0';
                sb.insert(0, (i + mut) % 10);
                mut = (i + mut) / 10;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("6913259244", "71103343"));
    }
}
