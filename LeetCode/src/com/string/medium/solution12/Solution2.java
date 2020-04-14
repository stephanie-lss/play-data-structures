package com.string.medium.solution12;

/**
 * @author LiSheng
 * @date 2020/4/13 13:35
 */
public class Solution2 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int idx = 0;
        while (num != 0) {
            int count = num / arab[idx];
            while (count-- > 0) {
                sb.append(roman[idx]);
            }
            num = num % arab[idx++];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().intToRoman(20));
        System.out.println(new Solution2().intToRoman(508));
        System.out.println(new Solution2().intToRoman(1004));
    }
}
