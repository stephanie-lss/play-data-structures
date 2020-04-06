package com.solution258;

/**
 * @author LiSheng
 * @date 2020/3/27 16:17
 */
public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        String str = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 48;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}
