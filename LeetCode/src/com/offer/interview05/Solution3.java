package com.offer.interview05;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/7/3 9:36
 */
public class Solution3 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] array = s.toCharArray();
        int blank = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                blank++;
            }
        }
        int p1 = array.length - 1;
        array = Arrays.copyOf(array, array.length + blank * 2);
        int p2 = array.length - 1;
        while (p1 != p2) {
            if (array[p1] != ' ') {
                array[p2--] = array[p1--];
            } else {
                p1--;
                array[p2] = '0';
                array[p2 - 1] = '2';
                array[p2 - 2] = '%';
                p2 -= 3;
            }
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        String S = " ";
        System.out.println(new Solution3().replaceSpace(S));
    }
}
