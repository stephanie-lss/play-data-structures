package com.math.easy.solution1323;

/**
 * @author LiSheng
 * @date 2020/4/9 13:26
 */
public class Solution2 {
    public int maximum69Number(int num) {
        int i = 9999 - num;
        if (i > 999) {
            return num + 3000;
        } else if (i > 99) {
            return num + 300;
        } else if (i > 9) {
            return num + 30;
        } else if (i == 3) {
            return num + 3;
        } else {
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maximum69Number(9669));
    }
}
