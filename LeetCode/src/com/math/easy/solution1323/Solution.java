package com.math.easy.solution1323;

/**
 * @author LiSheng
 * @date 2020/4/9 13:26
 */
public class Solution {
    public int maximum69Number(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximum69Number(9669));
    }
}
