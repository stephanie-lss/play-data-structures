package com.math.easy.solution633;

/**
 * @author LiSheng
 * @date 2020/4/8 18:59
 */
public class Solution2 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().judgeSquareSum(9));
    }
}
