package com.interview.solution5_7;

/**
 * @author LiSheng
 * @date 2020/6/28 13:52
 */
class Solution {
    public int exchangeBits(int num) {
        char[] array = ("0" + Integer.toBinaryString(num)).toCharArray();
        boolean swap = true;
        for (int i = array.length - 1; i >= 1; i--) {
            if (swap) {
                char tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
            }
            swap = !swap;
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = res * 2 + (array[i] - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exchangeBits(4));
    }
}