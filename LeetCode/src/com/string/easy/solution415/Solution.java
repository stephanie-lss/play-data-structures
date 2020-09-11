package com.string.easy.solution415;

/**
 * @author LiSheng
 * @date 2020/4/2 15:06
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int sum = 0;
        int tt = 0;
        int count = 1;
        while (n1 >= 0 || n2 >= 0) {
            int t1 = 0;
            if (n1 >= 0) {
                t1 = num1.charAt(n1--) - 48;
            }
            int t2 = 0;
            if (n2 >= 0) {
                t2 = num2.charAt(n2--) - 48;
            }
            int tmp = (t1 + t2) + tt;
            tt = 0;
            if (tmp >= 10) {
                sum = tmp % 10 * count + sum;
                tt = tmp / 10;
            } else {
                sum += tmp * count;
            }
            count *= 10;
        }
        if (tt != 0) {
            sum = (int) (Math.pow(10, Integer.max(num1.length(), num2.length())) * tt + sum);
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("184","18"));
    }
}
